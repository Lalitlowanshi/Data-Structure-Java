
class Solution {
    public int minOperations(String s) {
        int n = s.length();
        boolean sorted = true;
        char min = 'z', max = 'a';

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            min = (char) Math.min(min, c);
            max = (char) Math.max(max, c);

            if (i > 0 && c < s.charAt(i - 1)) {
                sorted = false;
            }
        }

        // Already sorted
        if (sorted) {
            return 0;
        }

        // Cannot sort a descending string of length 2
        if (n == 2) {
            return -1;
        }

        // Minimum is already at the start or maximum at the end
        if (s.charAt(0) == min || s.charAt(n - 1) == max) {
            return 1;
        }

        // Minimum or maximum occurs inside the string
        for (int i = 1; i < n - 1; i++) {
            char c = s.charAt(i);
            if (c == min || c == max) {
                return 2;
            }
        }

        // Minimum and maximum are both at the wrong ends
        return 3;
    }
}
