class Solution {
    public int missingNumber(int[] nums) {
        int ans = 0;
        Arrays.sort(nums);
        for(int i=1; i<nums.length; i++){
            if(nums[i-1]+1 != nums[i]){
                ans = nums[i] - 1;
            }
        }
        if(nums[nums.length-1] != nums.length && ans == 0){
            return nums[nums.length-1]+1;
        }
        return ans;
    }
}
