class Solution {
    public int largestCombination(int[] candidates) {
        int maxCount = 0;

        // Check each bit position (0 to 31)
        for (int bit = 0; bit < 32; bit++) {
            int count = 0;
            
            // Count how many numbers have the current bit set
            for (int num : candidates) {
                if ((num & (1 << bit)) != 0) {
                    count++;
                }
            }

            // Update the maximum count for this bit position
            maxCount = Math.max(maxCount, count);
        }

        return maxCount;
    }
}
