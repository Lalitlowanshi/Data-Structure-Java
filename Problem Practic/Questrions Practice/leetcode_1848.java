class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        int ans = Integer.MAX_VALUE;
        int temp = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == target)
                temp = Math.abs(i-start);
            else
                continue;
                
            if(ans > temp)
                ans = temp;
        }
        return ans;
    }
}
