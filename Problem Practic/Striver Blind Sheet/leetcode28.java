class Solution {
    public int strStr(String haystack, String needle) {

        int n = haystack.length();
        int m = needle.length();

        // loop till where needle can fit
        for (int i = 0; i <= n - m; i++) {
            int j = 0;

            // check characters
            while (j < m && haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
            }

            // if full needle matched
            if (j == m) {
                return i;
            }
        }

        return -1;
    }
}
