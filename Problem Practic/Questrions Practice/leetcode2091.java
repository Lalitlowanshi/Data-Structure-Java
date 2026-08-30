class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        int min = nums[0];
        int max = nums[0];
        int min_i = 0;
        int max_i = 0;

        if (n <= 2) return n;

        for (int i = 1; i < n; i++) {
            if (nums[i] < min) {
                min = nums[i];
                min_i = i;
            }

            if (nums[i] > max) {
                max = nums[i];
                max_i = i;
            }
        }

        // min_i ko chhota index bana do
        if (min_i > max_i) {
            int temp = min_i;
            min_i = max_i;
            max_i = temp;
        }

        // Dono left se
        int left = max_i + 1;

        // Dono right se
        int right = n - min_i;

        // Ek left se aur ek right se
        int both = (min_i + 1) + (n - max_i);

        return Math.min(left, Math.min(right, both));
    }
}


// Wrong Solution...

// class Solution {
//     public int minimumDeletions(int[] nums) {
//         int n = nums.length;
//         int min = nums[0];
//         int max = nums[0];
//         int min_i = 0;
//         int max_i = 0;
//         if(n <= 2) return n;

//         for(int i=1; i<n; i++){
//             if(nums[i] < min){
//                 min = nums[i];
//                 min_i = i;
//             }
//             if(nums[i] > max){
//                 max = nums[i];
//                 max_i = i;
//             }
//         }
//         System.out.println(min + " " + max);
//         if(min_i >= n/2 && max_i >= n/2){
//             return n - Math.min(min_i,max_i);
//         }
//         else if(min_i <= n/2 && max_i <= n/2){
//             return Math.max(min_i,max_i) + 1;
//         }
//         else if(min_i < n/2 && max_i > n/2){
//             return min_i + 1 + (n-max_i);
//         }
//         else if(min_i > n/2 && max_i < n/2){
//             return max_i + 1 + (n-min_i);
//         }
//         return -1;
//     }
// }
