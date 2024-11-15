class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;
        // Find the longest non-decreasing prefix
        int left = 0;
        while (left < n - 1 && arr[left] <= arr[left + 1]) {
            left++;
        }
        
        // If the entire array is sorted
        if (left == n - 1) {
            return 0;
        }
        
        // Find the longest non-decreasing suffix
        int right = n - 1;
        while (right > 0 && arr[right] >= arr[right - 1]) {
            right--;
        }
        
        // The minimum length of the subarray to remove
        int minLength = Math.min(n - left - 1, right);

        // Try merging prefix and suffix by adjusting pointers
        int i = 0, j = right;
        while (i <= left && j < n) {
            if (arr[i] <= arr[j]) {
                minLength = Math.min(minLength, j - i - 1);
                i++;
            } else {
                j++;
            }
        }
        
        return minLength;
    }
}
