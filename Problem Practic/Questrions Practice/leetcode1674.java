class Solution {
    public int minMoves(int[] nums, int limit) {

        int n = nums.length;

        int[] diff = new int[2 * limit + 2];

        for (int i = 0; i < n / 2; i++) {

            int a = nums[i];
            int b = nums[n - 1 - i];

            int low = Math.min(a, b);
            int high = Math.max(a, b);

            int left = low + 1;
            int right = high + limit;

            int sum = a + b;

            // initially 2 moves for all
            diff[2] += 2;

            // one move range
            diff[left] -= 1;
            diff[right + 1] += 1;

            // zero move at exact sum
            diff[sum] -= 1;
            diff[sum + 1] += 1;
        }

        int ans = Integer.MAX_VALUE;

        int curr = 0;

        for (int s = 2; s <= 2 * limit; s++) {

            curr += diff[s];

            ans = Math.min(ans, curr);
        }

        return ans;
    }
}
