class Solution {
    public int zigZagArrays(int n, int l, int r) {
        int mod = 1_000_000_007;
        int m = r - l + 1;

        long[][][] dp = new long[n + 1][m][2];

        for (int j = 0; j < m; j++) {
            dp[2][j][0] = m - j - 1;
            dp[2][j][1] = j;
        }

        for (int i = 3; i <= n; i++) {
            long[] prefixInc = new long[m + 1];
            long[] prefixDec = new long[m + 1];

            for (int j = 0; j < m; j++) {
                prefixInc[j + 1] = (prefixInc[j] + dp[i - 1][j][1]) % mod;
                prefixDec[j + 1] = (prefixDec[j] + dp[i - 1][j][0]) % mod;
            }

            for (int j = 0; j < m; j++) {
                dp[i][j][0] =
                        (prefixInc[m] - prefixInc[j + 1] + mod) % mod;

                dp[i][j][1] = prefixDec[j];
            }
        }

        long ans = 0;
        for (int j = 0; j < m; j++) {
            ans = (ans + dp[n][j][0] + dp[n][j][1]) % mod;
        }

        return (int) ans;
    }
}
