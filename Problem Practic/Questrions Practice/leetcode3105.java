
class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int n = nums.length;
        int count = 1;

        int i = 0, j = 1;

        // Increasing subarray
        while (j < n) {
            if (nums[j - 1] < nums[j]) {
                count = Math.max(count, j - i + 1);
                j++;
            } else {
                i = j;
                j++;
            }
        }

        int k = 0, l = 1;

        // Decreasing subarray
        while (l < n) {
            if (nums[l - 1] > nums[l]) {
                count = Math.max(count, l - k + 1);
                l++;
            } else {
                k = l;
                l++;
            }
        }

        return count;
    }
}
