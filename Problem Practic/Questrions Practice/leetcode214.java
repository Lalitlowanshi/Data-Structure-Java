package Leetcode;

public class leetcode214 {
    public String shortestPalindrome(String s) {
        String rev = new StringBuilder(s).reverse().toString();
        String l = s + "#" + rev; // Create a temporary string to calculate the prefix array
        int[] p = new int[l.length()]; // KMP table

        // Build the KMP table (also known as the "partial match" table)
        for (int i = 1; i < l.length(); i++) {
            int j = p[i - 1];
            while (j > 0 && l.charAt(i) != l.charAt(j)) {
                j = p[j - 1];
            }
            if (l.charAt(i) == l.charAt(j)) {
                j++;
            }
            p[i] = j;
        }

        // Append the characters in reverse that are not part of the palindrome
        return rev.substring(0, s.length() - p[l.length() - 1]) + s;
    }
}