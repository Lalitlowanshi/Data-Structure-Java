class Solution {
    public int[] countBits(int n) {
        int [] nums = new int [n+1];
        int index = 0;
        for(int i=0; i<=n; i++){
            int count = 0;
            String s = Integer.toBinaryString(i);
            for(int j=0; j<s.length(); j++){
                if(s.charAt(j) == '1'){
                    count++;
                }
            }
            nums[index++] = count;
        }
        return nums;
    }
}



// optimized Approach


// class Solution {
//     public int[] countBits(int n) {
//         int[] nums = new int[n + 1];

//         for (int i = 1; i <= n; i++) {
//             nums[i] = nums[i >> 1] + (i & 1); // DP formula
//         }
        
//         return nums;
//     }
// }
