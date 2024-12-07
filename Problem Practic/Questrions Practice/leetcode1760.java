class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int left = 1, right = 0;
        for (int num : nums) {
            right = Math.max(right, num); // Find the maximum number in the array
        }
        
        int result = right;
        while (left <= right) {
            int mid = left + (right - left) / 2; // Middle candidate
            if (canDivide(nums, mid, maxOperations)) {
                result = mid; // Update result if feasible
                right = mid - 1; // Search left half
            } else {
                left = mid + 1; // Search right half
            }
        }
        
        return result;
    }

    private boolean canDivide(int[] nums, int maxSize, int maxOperations) {
        int operations = 0;
        for (int num : nums) {
            if (num > maxSize) {
                operations += (num - 1) / maxSize; // Count splits required
            }
        }
        return operations <= maxOperations;
    }
}
