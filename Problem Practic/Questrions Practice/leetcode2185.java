class Solution {
    public int prefixCount(String[] nums, String pref) {
        int count = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i].startsWith(pref)){
                count++;
            }
        }
        return count;
    }
}
