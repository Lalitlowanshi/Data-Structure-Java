class Solution {
    private int maxOr = 0;  // To store the maximum OR value
    private int count = 0;  // To store the count of subsets with max OR value

    public int countMaxOrSubsets(int[] nums) {
        // Find the maximum possible OR value by calculating the OR of the entire array
        for (int num : nums) {
            maxOr |= num;
        }

        // Use a recursive backtracking approach to explore all subsets
        backtrack(nums, 0, 0); // Start with index 0 and initial OR value 0
        return count;
    }

    private void backtrack(int[] nums, int index, int currentOr) {
        // Base case: If we have processed all elements, check if the current OR is equal to maxOr
        if (index == nums.length) {
            if (currentOr == maxOr) {
                count++; // Increment the count if current OR is equal to maxOr
            }
            return;
        }

        // Explore two possibilities: 
        // 1. Include nums[index] in the subset
        backtrack(nums, index + 1, currentOr | nums[index]);

        // 2. Exclude nums[index] from the subset
        backtrack(nums, index + 1, currentOr);
    }
}

