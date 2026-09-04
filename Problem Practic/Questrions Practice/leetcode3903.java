class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int max = nums[0];
        int ans = Integer.MAX_VALUE;
        int result = -1;
        for(int i=0; i<n; i++){
            if(nums[i] > max){
                max = nums[i];
            }
            int j = i;
            int min = nums[i];
            
            while(j < n){
                if(nums[j] < min){
                    min = nums[j];
                }
                j++;
            }
            int idxval = max - min;
            if(idxval < ans && idxval <= k){
                ans = idxval;
                return i;
            }
            
        }
        return result;
    }
}
