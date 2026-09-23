class Solution {
    public int minOperations(int[] nums, int x) {

        int n = nums.length;

        int totalSum = 0;

        for (int num : nums) {
            totalSum += num;
        }

        int target = totalSum - x;

        // If we need to keep nothing
        if (target == 0) {
            return n;
        }

        int left = 0;
        int currentSum = 0;
        int maxLength = -1;

        for (int right = 0; right < n; right++) {

            currentSum += nums[right];

            while (left <= right && currentSum > target) {
                currentSum -= nums[left];
                left++;
            }

            if (currentSum == target) {
                maxLength = Math.max(maxLength, right - left + 1);
            }
        }

        if (maxLength == -1) {
            return -1;
        }

        return n - maxLength;
    }
}
