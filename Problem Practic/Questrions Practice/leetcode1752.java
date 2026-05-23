class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;
        int count = 0;

        for(int i = 0; i < n; i++) {
            if(nums[i] > nums[(i + 1) % n]) {
                count++;
            }
        }

        return count <= 1;
    }
}



// Wrong Solution..........

// class Solution {
//     public boolean check(int[] nums) {
//         int n = nums.length;
//         int temp = 0;
//         for(int i=0; i<n-1; i++){
//             if(nums[i] > nums[i+1]){
//                 temp++;
//                 if(temp > 1){
//                     return false;
//                 }
//             }
//         }
//         return true;
//     }
// }
