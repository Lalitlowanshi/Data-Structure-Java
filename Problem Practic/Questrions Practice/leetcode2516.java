class Solution {
    public static int takeCharacters(String s, int k) {
        if (k == 0) return 0; // If k is 0, no need to take any characters.

        // Count total occurrences of 'a', 'b', 'c'.
        int[] totalCount = new int[3];
        for (char c : s.toCharArray()) {
            totalCount[c - 'a']++;
        }

        // If any character's total count is less than k, return -1.
        for (int count : totalCount) {
            if (count < k) return -1;
        }

        // Sliding window to minimize the characters taken from left and right.
        int n = s.length();
        int[] currentCount = new int[3];
        int maxWindowSize = 0;

        for (int left = 0, right = 0; right < n; right++) {
            currentCount[s.charAt(right) - 'a']++;

            // Shrink the window if any character count inside exceeds `totalCount - k`.
            while (currentCount[0] > totalCount[0] - k ||
                   currentCount[1] > totalCount[1] - k ||
                   currentCount[2] > totalCount[2] - k) {
                currentCount[s.charAt(left) - 'a']--;
                left++;
            }

            // Update the maximum valid window size.
            maxWindowSize = Math.max(maxWindowSize, right - left + 1);
        }

        // The minimum number of characters to take is the total length minus the largest valid window size.
        return n - maxWindowSize;
    }
}
