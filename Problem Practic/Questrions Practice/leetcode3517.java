class Solution {
    public String smallestPalindrome(String s) {
        int[] freq = new int[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        StringBuilder left = new StringBuilder();
        char mid = 0;

        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < freq[i] / 2; j++) {
                left.append((char) ('a' + i));
            }

            if ((freq[i] & 1) == 1) {
                mid = (char) ('a' + i);
            }
        }

        StringBuilder ans = new StringBuilder();
        ans.append(left);

        if (mid != 0) {
            ans.append(mid);
        }

        ans.append(new StringBuilder(left).reverse());

        return ans.toString();
    }
}
