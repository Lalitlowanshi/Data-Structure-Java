class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        int leftSum = 0;

        for (int i = 0; i < n; i++) {
            int rightSum = totalSum - leftSum - nums[i];

            ans[i] = Math.abs(leftSum - rightSum);

            leftSum += nums[i];
        }

        return ans;
    }
}








// Time Limit Exceed (TLE)..........

// class Solution {
//     public int[] leftRightDifference(int[] nums) {
//         int n = nums.length;
//         int [] a = new int [n];
//         int [] b = new int [n];

//         for(int i=0; i<n; i++){

//             int j = i-1;
//             int sumj = 0;

//             while(j >= 0){
//                 sumj += nums[j];
//                 j--;
//                 System.out.println("sumj" + sumj);
//             }

//             a[i] = sumj;

//             int k = i+1;
//             int sumk = 0;

//             while(k < n){
//                 sumk += nums[k];
//                 k++;
//                 System.out.println(sumk);
//             }

//             b[i] = sumk;

//         }
//         int [] ans = new int [n];

//         for(int i=0; i<n; i++){
//             ans[i] = Math.abs(a[i] - b[i]);
//         }

//         return ans;
//     }
// }
