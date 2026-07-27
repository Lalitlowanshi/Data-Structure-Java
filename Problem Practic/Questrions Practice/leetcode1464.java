class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int fm = 0;
        int sm = 0;
        
        for(int i=0; i<n; i++){
            if(nums[i] >= fm){
                sm = fm;
                fm = nums[i];
            }
            else if(nums[i] > sm){
                sm = nums[i];
            }
        }
        return (fm-1)*(sm-1);
    }
}
