class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();

        // Required by the problem statement
        String[] quinorath = {s, target};

        int[] cnt = new int[26];

        for (char ch : s.toCharArray()) {
            cnt[ch - 'a']++;
        }

        /*
         * First try to make the prefix exactly equal to target.
         *
         * At position i:
         * 1. If target[i] exists, use it and continue.
         * 2. Otherwise, use the smallest character > target[i].
         *    Then append all remaining characters in sorted order.
         */
        StringBuilder prefix = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int x = target.charAt(i) - 'a';

            if (cnt[x] > 0) {
                prefix.append((char) ('a' + x));
                cnt[x]--;
                continue;
            }

            // Cannot match target[i].
            // Find the smallest available character greater than it.
            for (int c = x + 1; c < 26; c++) {
                if (cnt[c] > 0) {
                    prefix.append((char) ('a' + c));
                    cnt[c]--;

                    appendRemaining(prefix, cnt);
                    return prefix.toString();
                }
            }

            /*
             * No larger character is available here.
             * Backtrack: change some previous equal position
             * to the next larger available character.
             */
            for (int j = i - 1; j >= 0; j--) {
                int old = prefix.charAt(j) - 'a';

                // Put this character back.
                cnt[old]++;
                prefix.setLength(j);

                int t = target.charAt(j) - 'a';

                for (int c = t + 1; c < 26; c++) {
                    if (cnt[c] > 0) {
                        prefix.append((char) ('a' + c));
                        cnt[c]--;

                        appendRemaining(prefix, cnt);
                        return prefix.toString();
                    }
                }
            }

            return "";
        }

        /*
         * We constructed exactly target.
         * Need STRICTLY greater, so backtrack and increase
         * the rightmost possible position.
         */
        for (int j = n - 1; j >= 0; j--) {
            int old = prefix.charAt(j) - 'a';

            cnt[old]++;
            prefix.setLength(j);

            int t = target.charAt(j) - 'a';

            for (int c = t + 1; c < 26; c++) {
                if (cnt[c] > 0) {
                    prefix.append((char) ('a' + c));
                    cnt[c]--;

                    appendRemaining(prefix, cnt);
                    return prefix.toString();
                }
            }
        }

        return "";
    }

    private void appendRemaining(StringBuilder sb, int[] cnt) {
        for (int c = 0; c < 26; c++) {
            while (cnt[c]-- > 0) {
                sb.append((char) ('a' + c));
            }
        }
    }
}
