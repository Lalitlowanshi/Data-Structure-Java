class Solution {
    public int[] validSequence(String word1, String word2) {

        int n = word1.length(), m = word2.length();

        // dp[i] = word1[i...] se word2 ka maximum exact suffix
        int[] dp = new int[n + 1];

        int j = m - 1;

        for (int i = n - 1; i >= 0; i--) {
            dp[i] = dp[i + 1];

            if (j >= 0 && word1.charAt(i) == word2.charAt(j)) {
                dp[i]++;
                j--;
            }
        }

        int[] ans = new int[m];

        int i = 0;
        j = 0;

        // Pehle mismatch tak greedy
        while (i < n && j < m) {

            if (word1.charAt(i) == word2.charAt(j)) {
                ans[j++] = i;
            } 
            else if (dp[i + 1] >= m - j - 1) {
                // Ye mismatch use kar sakte hain
                ans[j++] = i++;
                break;
            }

            i++;
        }

        // Mismatch ke baad exact matching
        while (i < n && j < m) {
            if (word1.charAt(i) == word2.charAt(j)) {
                ans[j++] = i;
            }
            i++;
        }

        return j == m ? ans : new int[0];
    }
}
