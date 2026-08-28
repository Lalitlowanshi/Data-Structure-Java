class Solution {
    public String lexPalindromicPermutation(String s, String target) {
        int n = s.length();

        // Frequency of characters in s
        int[] cnt = new int[26];

        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }

        // A palindrome can have at most one odd frequency.
        int odd = 0;
        int mid = -1;

        for (int i = 0; i < 26; i++) {
            if (cnt[i] % 2 == 1) {
                odd++;
                mid = i;
            }
        }

        if (odd > 1) {
            return "";
        }

        // Characters available for the left half.
        int[] half = new int[26];

        for (int i = 0; i < 26; i++) {
            half[i] = cnt[i] / 2;
        }

        int halfLen = n / 2;

        StringBuilder left = new StringBuilder();

        /*
         * Greedily construct the left half.
         */
        for (int pos = 0; pos < halfLen; pos++) {

            boolean found = false;

            for (int c = 0; c < 26; c++) {

                if (half[c] == 0) {
                    continue;
                }

                // Try putting this character here.
                half[c]--;
                left.append((char) ('a' + c));

                /*
                 * Complete the remaining positions with the
                 * largest possible characters.
                 *
                 * If even this largest palindrome is not
                 * greater than target, this choice is impossible.
                 */
                if (canBeGreater(left, half, mid, target)) {
                    found = true;
                    break;
                }

                // Undo
                left.deleteCharAt(left.length() - 1);
                half[c]++;
            }

            if (!found) {
                return "";
            }
        }

        // Construct final palindrome.
        StringBuilder ans = new StringBuilder();

        ans.append(left);

        // Middle character for odd length.
        if (mid != -1) {
            ans.append((char) ('a' + mid));
        }

        // Reverse of left half.
        for (int i = left.length() - 1; i >= 0; i--) {
            ans.append(left.charAt(i));
        }

        String result = ans.toString();

        return result.compareTo(target) > 0 ? result : "";
    }

    private boolean canBeGreater(
            StringBuilder prefix,
            int[] half,
            int mid,
            String target) {

        StringBuilder left = new StringBuilder(prefix);

        // Put remaining characters in descending order.
        for (int c = 25; c >= 0; c--) {
            for (int k = 0; k < half[c]; k++) {
                left.append((char) ('a' + c));
            }
        }

        // Construct the largest possible palindrome.
        StringBuilder palindrome = new StringBuilder();

        palindrome.append(left);

        if (mid != -1) {
            palindrome.append((char) ('a' + mid));
        }

        for (int i = left.length() - 1; i >= 0; i--) {
            palindrome.append(left.charAt(i));
        }

        return palindrome.toString().compareTo(target) > 0;
    }
}
