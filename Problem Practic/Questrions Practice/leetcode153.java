class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int i=0;
        int j=n-1;
        int mid;
        while(i<j){
            mid = i+(j-i)/2;
            if(nums[mid] > nums[j]){
                i = mid+1;
            }else{
                j = mid;
            }
        }
        return nums[i];
    }
}
