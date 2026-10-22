
class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;

        // Find the position of 0
        int zero = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                zero = i;
                break;
            }
        }

        int ans = Integer.MAX_VALUE;

        // Check circular order in both directions
        if (isValid(nums, zero, 1)) {
            ans = Math.min(ans, zero);
            ans = Math.min(ans, n - zero + 2);
        }

        if (isValid(nums, zero, -1)) {
            ans = Math.min(ans, zero + 2);
            ans = Math.min(ans, n - zero);
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private boolean isValid(int[] nums, int zero, int step) {
        int n = nums.length;

        for (int i = 1; i < n; i++) {
            int prev = (zero + (i - 1) * step + n) % n;
            int curr = (zero + i * step + n) % n;

            if (nums[curr] != nums[prev] + 1) {
                return false;
            }
        }

        return true;
    }
}
