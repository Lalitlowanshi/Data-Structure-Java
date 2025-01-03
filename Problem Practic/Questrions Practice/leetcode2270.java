class Solution {
    public int waysToSplitArray(int[] nums) {
        long totalSum = 0; // To handle large values, use long
        for (int num : nums) {
            totalSum += num;
        }

        long leftSum = 0;
        int count = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            leftSum += nums[i];
            long rightSum = totalSum - leftSum;
            if (leftSum >= rightSum) {
                count++;
            }
        }

        return count;
    }
}
