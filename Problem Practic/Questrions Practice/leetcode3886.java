
class Solution {
    public int sortableIntegers(int[] nums) {
        int n = nums.length;

        int[] prefMax = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefMax[i + 1] = Math.max(prefMax[i], nums[i]);
        }

        int[] suffMin = new int[n + 1];
        suffMin[n] = Integer.MAX_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            suffMin[i] = Math.min(nums[i], suffMin[i + 1]);
        }

        // prefDrop[i] counts descents in nums[0..i]
        int[] prefDrop = new int[n];
        for (int i = 1; i < n; i++) {
            prefDrop[i] = prefDrop[i - 1]
                    + (nums[i - 1] > nums[i] ? 1 : 0);
        }

        int ans = 0;

        // Enumerate all divisors of n
        for (int d = 1; d <= n / d; d++) {
            if (n % d != 0) {
                continue;
            }

            if (check(nums, prefMax, suffMin, prefDrop, d)) {
                ans += d;
            }

            int other = n / d;
            if (other != d &&
                check(nums, prefMax, suffMin, prefDrop, other)) {
                ans += other;
            }
        }

        return ans;
    }

    private boolean check(
            int[] nums,
            int[] prefMax,
            int[] suffMin,
            int[] prefDrop,
            int k) {

        int n = nums.length;

        for (int start = 0; start < n; start += k) {
            int end = start + k - 1;

            // Count circular descents inside this block
            int drops = prefDrop[end] - prefDrop[start];

            if (nums[end] > nums[start]) {
                drops++;
            }

            // The block must be sortable by rotation.
            if (drops > 1) {
                return false;
            }

            // All previous elements must be <= all remaining elements.
            if (prefMax[start] > suffMin[start]) {
                return false;
            }
        }

        return true;
    }
}
