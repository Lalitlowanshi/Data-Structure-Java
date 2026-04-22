class Solution {
    public List<String> twoEditWords(String[] arr, String[] nums) {
        int n = arr.length;
        int m = nums.length;
        int len = arr[0].length();
        List<String> ans = new ArrayList<>();

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                int count = 0;
                for(int k=0; k<len; k++){
                    if(arr[i].charAt(k) != nums[j].charAt(k)){
                        count++;
                    }
                }               
                if(count <= 2){
                    ans.add(arr[i]);
                    break;
                }
            }
        }
        return ans;
    }
}
