class Solution {
    Integer[][] dp;

    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        dp = new Integer[n][n];

        return solve(nums, 0, n - 1) >= 0;
    }

    private int solve(int[] nums, int l, int r) {
        if (l == r)
            return nums[l];

        if (dp[l][r] != null)
            return dp[l][r];

        int takeLeft = nums[l] - solve(nums, l + 1, r);
        int takeRight = nums[r] - solve(nums, l, r - 1);

        return dp[l][r] = Math.max(takeLeft, takeRight);
    }
}
