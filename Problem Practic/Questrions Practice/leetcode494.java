class Solution {
    static int count ;
    public int findTargetSumWays(int[] nums, int target) {
        count = 0;
        return helper(nums, target, 0, 0);
    }
    public int helper(int[] nums, int target, int index, int result){
        
        if(index == nums.length) {
            return result == target ? 1 : 0;
        }

        int left = helper(nums, target, index+1, result+nums[index]);
        int right = helper(nums, target, index+1, result-nums[index]);

        
        return left + right ;
    }
}
