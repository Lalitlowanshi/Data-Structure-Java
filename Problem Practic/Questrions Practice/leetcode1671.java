class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;

        int[] LIS = new int[n];
        Arrays.fill(LIS, 1);
        int[] LDS = new int[n];
        Arrays.fill(LDS, 1);

        // Calculate LIS
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    LIS[i] = Math.max(LIS[i], LIS[j] + 1);
                }
            }
        }

        // Calculate LDS
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] > nums[j]) {
                    LDS[i] = Math.max(LDS[i], LDS[j] + 1);
                }
            }
        }

        int minRemovals = n;
        for (int i = 0; i < n; i++) { // Treat each element as the peak and find minimum removals
            if (LIS[i] > 1 && LDS[i] > 1) { // Mountain array must be of minimum length 3
                minRemovals = Math.min(minRemovals, n - (LIS[i] + LDS[i] - 1));
            }
        }
        return minRemovals;
    }
}
