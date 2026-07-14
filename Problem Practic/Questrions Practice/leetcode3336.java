import java.util.*;

class Solution {
    static final int MOD = 1_000_000_007;

    public int subsequencePairCount(int[] nums) {
        int max = 200;

        long[][] dp = new long[max + 1][max + 1];
        dp[0][0] = 1;

        for (int x : nums) {
            long[][] newDp = new long[max + 1][max + 1];

            for (int g1 = 0; g1 <= max; g1++) {
                for (int g2 = 0; g2 <= max; g2++) {
                    long ways = dp[g1][g2];
                    if (ways == 0) continue;

                    // 1. skip
                    newDp[g1][g2] = (newDp[g1][g2] + ways) % MOD;

                    // 2. add to seq1
                    int ng1 = gcd(g1, x);
                    newDp[ng1][g2] = (newDp[ng1][g2] + ways) % MOD;

                    // 3. add to seq2
                    int ng2 = gcd(g2, x);
                    newDp[g1][ng2] = (newDp[g1][ng2] + ways) % MOD;
                }
            }

            dp = newDp;
        }

        long ans = 0;

        for (int g = 1; g <= max; g++) {
            ans = (ans + dp[g][g]) % MOD;
        }

        return (int) ans;
    }

    private int gcd(int a, int b) {
        if (a == 0) return b;
        return gcd(b % a, a);
    }
}
