class Solution {
       public static int countGoodStrings(int low, int high, int zero, int one) {
        int mod = 1_000_000_007;
        int[] dp = new int[high + 1];
        dp[0] = 1; // Base case: empty string

        // Calculate number of good strings of length i
        for (int i = 1; i <= high; i++) {
            if (i >= zero) {
                dp[i] = (dp[i] + dp[i - zero]) % mod;
            }
            if (i >= one) {
                dp[i] = (dp[i] + dp[i - one]) % mod;
            }
        }

        // Sum up the results for lengths between low and high
        int result = 0;
        for (int i = low; i <= high; i++) {
            result = (result + dp[i]) % mod;
        }

        return result;
    }
}
