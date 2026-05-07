class Solution {
    public int[] maxValue(int[] nums) {
        int n = nums.length;

        int[] suffixMin = new int[n];
        suffixMin[n - 1] = nums[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            suffixMin[i] = Math.min(nums[i], suffixMin[i + 1]);
        }

        int[] ans = new int[n];

        int start = 0;
        int currentMax = nums[0];

        for (int i = 0; i < n - 1; i++) {
            currentMax = Math.max(currentMax, nums[i]);

            // If all left values <= all right values,
            // then no jump can connect these two parts.
            if (currentMax <= suffixMin[i + 1]) {

                int segmentMax = currentMax;

                for (int j = start; j <= i; j++) {
                    ans[j] = segmentMax;
                }

                start = i + 1;

                if (start < n) {
                    currentMax = nums[start];
                }
            }
        }

        // Last segment
        int segmentMax = currentMax;
        for (int j = start; j < n; j++) {
            segmentMax = Math.max(segmentMax, nums[j]);
        }

        for (int j = start; j < n; j++) {
            ans[j] = segmentMax;
        }

        return ans;
    }
}
