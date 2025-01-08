class Solution {
    public int countPrefixSuffixPairs(String[] nums) {
        int count = 0;
        for(int i=0; i<nums.length; i++){
            for(int j=i; j<nums.length; j++){
                if(i == j){
                    continue;
                }
                if(nums[j].startsWith(nums[i]) && nums[j].endsWith(nums[i])){
                    count++;
                }
            }
        }
        return count;
    }
}
