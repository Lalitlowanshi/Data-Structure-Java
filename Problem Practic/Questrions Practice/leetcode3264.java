class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];

        // Iterate through all possible k-size subarrays
        for (int i = 0; i <= nums.length - k; i++) {
            boolean isConsecutive = true;

            // Check if the current subarray is sorted and consecutive
            for (int j = i; j < i + k - 1; j++) {
                if (nums[j] + 1 != nums[j + 1]) {
                    isConsecutive = false;
                    break;
                }
            }

            // If the subarray is consecutive, find the maximum element
            if (isConsecutive) {
                int maxElement = Integer.MIN_VALUE;
                for (int j = i; j < i + k; j++) {
                    maxElement = Math.max(maxElement, nums[j]);
                }
                result[i] = maxElement;
            } else {
                result[i] = -1;
            }
        }

        return result;
    }
}







//Another solution of the same leetcode problem

/*
class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        int count = 0;
        int n = nums.length;
        int arr[] = new int[n];
        arr = nums;
        while (count != k) {
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                if (min > arr[i]) {
                    min = arr[i];
                }
            }
            for (int i = 0; i < n; i++) {
                if (min == arr[i]) {
                    arr[i] = min * multiplier;
                    count++;
                    break;
                }
            }
        }
        return arr;
    }
}
*/
