class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int max = 0;
        int i = 0;
        int j = 0;

        while(i<n && j<m){
            if(nums1[i] <= nums2[j]){
                if(max < j-i){
                    max = j-i;
                }
                j++;
            }
            else{
                i++;
            }
        }
        return max;
    }
}




// Time Limit Exceeded (TLE).....

// class Solution {
//     public int maxDistance(int[] nums1, int[] nums2) {
//         int n = nums1.length;
//         int m = nums2.length;
//         int max = 0;

//         for(int i=0; i<n; i++){
//             for(int j=m-1; j>=0; j--){
//                 if(nums1[i] <= nums2[j]){
//                     if(max < j-i){
//                         max = j-i;
//                     }
//                     continue;
//                 }
//             }
//         }
//         return max;
//     }
// }




// Time Limit Exceeded (TLE).....

// class Solution {
//     public int maxDistance(int[] nums1, int[] nums2) {
//         int max = 0;
//         int n = nums1.length;
//         int m = nums2.length;

//         for(int i=0; i<n; i++){
//             for(int j=0; j<m; j++){
//                 if(nums1[i] <= nums2[j]){
//                     if(j-i > max){
//                         max = j-i;
//                     }
//                 }
//                 else{
//                     continue;
//                 }
//             }
//         }
//         return max;
//     }
// }
