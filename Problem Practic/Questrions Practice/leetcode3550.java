class Solution {
    public int smallestIndex(int[] nums) {
        int n = nums.length;
        int temp = 0;
        int sum = 0;

        for(int i=0; i<n; i++){
            temp = nums[i];
            sum = 0;
            
            while(temp != 0){
                sum += temp%10;
                temp /= 10;
            }
            if(sum == i){
                return i;
            }
        }
        return -1;
    }
}
