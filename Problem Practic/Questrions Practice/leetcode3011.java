class Solution {
    public boolean canSortArray(int[] nums) {
        // Repeat until no swaps can be made
        boolean swapped;
        do {
            swapped = false;
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] > nums[i + 1]) {
                    // Check if the two adjacent elements have the same number of set bits
                    if (Integer.bitCount(nums[i]) == Integer.bitCount(nums[i + 1])) {
                        // Swap if they have the same set bits
                        int temp = nums[i];
                        nums[i] = nums[i + 1];
                        nums[i + 1] = temp;
                        swapped = true;
                    } else {
                        // If they can't be swapped to sort, return false
                        return false;
                    }
                }
            }
        } while (swapped);

        return true;
    }
}
