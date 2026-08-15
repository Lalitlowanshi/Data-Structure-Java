class Solution {
    public int longestSubsequence(int[] nums) {
        int xor = 0;
        int zeroCount = 0;
        int n = nums.length;

        for (int x : nums) {
            xor ^= x;
            if (x == 0) {
                zeroCount++;
            }
        }

        if (xor != 0) {
            return n;
        }

        return (zeroCount == n) ? 0 : n - 1;
    }
}
