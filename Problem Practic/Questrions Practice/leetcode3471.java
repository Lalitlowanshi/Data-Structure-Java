import java.util.*;

class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;

        // Case 1
        if (k == 1) {
            Map<Integer, Integer> freq = new HashMap<>();
            for (int num : nums) {
                freq.put(num, freq.getOrDefault(num, 0) + 1);
            }

            int ans = -1;
            for (int num : nums) {
                if (freq.get(num) == 1) {
                    ans = Math.max(ans, num);
                }
            }
            return ans;
        }

        // Case 2
        if (k == n) {
            int ans = nums[0];
            for (int num : nums) {
                ans = Math.max(ans, num);
            }
            return ans;
        }

        // Case 3
        int ans = -1;

        if (isUnique(nums, 0)) {
            ans = Math.max(ans, nums[0]);
        }

        if (isUnique(nums, n - 1)) {
            ans = Math.max(ans, nums[n - 1]);
        }

        return ans;
    }

    private boolean isUnique(int[] nums, int index) {
        for (int i = 0; i < nums.length; i++) {
            if (i != index && nums[i] == nums[index]) {
                return false;
            }
        }
        return true;
    }
}
