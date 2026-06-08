class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        
        int[] result = new int[n];
        int idx = 0;

        // Step 1: elements < pivot
        for (int num : nums) {
            if (num < pivot) {
                result[idx++] = num;
            }
        }

        // Step 2: elements == pivot
        for (int num : nums) {
            if (num == pivot) {
                result[idx++] = num;
            }
        }

        // Step 3: elements > pivot
        for (int num : nums) {
            if (num > pivot) {
                result[idx++] = num;
            }
        }

        return result;
    }
}
