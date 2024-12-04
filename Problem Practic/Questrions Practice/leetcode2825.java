public class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int n = str1.length(), m = str2.length();
        int i = 0, j = 0;

        while (i < n && j < m) {
            char c1 = str1.charAt(i);
            char c2 = str2.charAt(j);
            
            // Check if c1 can match c2 with at most one cyclic increment
            if (c1 == c2 || (c1 - 'a' + 1) % 26 + 'a' == c2) {
                j++; // Move to the next character in str2
            }
            i++; // Move to the next character in str1
        }

        // If we've matched all characters of str2, return true
        return j == m;
    }
}
