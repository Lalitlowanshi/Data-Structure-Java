class Solution {
    public int distinctSubseqII(String s) {
        int MOD = 1_000_000_007;

        // dp[i] = number of distinct non-empty subsequences
        // after processing the first i characters.
        long[] dp = new long[s.length() + 1];
        dp[0] = 1; // empty subsequence

        // Last contribution of each character
        long[] last = new long[26];

        for (int i = 1; i <= s.length(); i++) {
            int c = s.charAt(i - 1) - 'a';

            // Every existing subsequence can either:
            // 1. not use current character
            // 2. append current character
            dp[i] = (2 * dp[i - 1]) % MOD;

            // Remove duplicate subsequences created when this
            // character appeared previously.
            dp[i] = (dp[i] - last[c] + MOD) % MOD;

            // Contribution associated with this character
            last[c] = dp[i - 1];
        }

        // Remove the empty subsequence
        return (int) ((dp[s.length()] - 1 + MOD) % MOD);
    }
}
