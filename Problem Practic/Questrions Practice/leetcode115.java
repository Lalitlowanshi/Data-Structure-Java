class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();

        long[] dp = new long[n + 1];

        // Empty t can be formed in exactly one way
        dp[0] = 1;

        for (int i = 1; i <= m; i++) {
            // Go backwards so dp[j - 1] is still from the previous row
            for (int j = n; j >= 1; j--) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[j] = dp[j] + dp[j - 1];
                }
            }
        }

        return (int) dp[n];
    }
}
