class Solution {
    public int minElement(int[] nums) {
        int min = Integer.MAX_VALUE;

        for (int num : nums) {
            int sum = 0;
            int temp = num;

            while (temp > 0) {
                sum += temp % 10;
                temp /= 10;
            }

            min = Math.min(min, sum);
        }

        return min;
    }
}


// My Solution.......


// class Solution {
//     public int minElement(int[] nums) {
//         int n = nums.length;
//         int [] arr = new int[n];
//         int idx = 0;
//         int i = 0;
//         int temp = 0;
//         while(i < n){
//             while(nums[i] != 0){
//                 temp += nums[i] % 10;
//                 nums[i] /= 10;
//             }
//             i++;
//             arr[idx++] = temp;
//             temp = 0;
//         }
//         Arrays.sort(arr);
//         int min = arr[0];
//         return min;
//     }
// }
