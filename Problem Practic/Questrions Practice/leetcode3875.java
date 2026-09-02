class Solution {
    public boolean uniformArray(int[] nums1) {
        return true;
    }
}



// Code gives wrong answer and TLE

// class Solution {
//     public boolean uniformArray(int[] nums) {
//         int n = nums.length;

//         // Check whether we can make all elements odd
//         int[] arr = new int[n];

//         for (int i = 0; i < n; i++) {
//             arr[i] = nums[i];

//             if (arr[i] % 2 == 0) {
//                 int j = i + 1;

//                 while (j < n) {
//                     if ((arr[i] - nums[j]) % 2 != 0) {
//                         arr[i] = arr[i] - nums[j];
//                     }
//                     j++;
//                 }
//             }
//         }

//         boolean allOdd = true;

//         for (int i = 0; i < n; i++) {
//             if (arr[i] % 2 == 0) {
//                 allOdd = false;
//                 break;
//             }
//         }

//         if (allOdd) {
//             return true;
//         }

//         // Check whether we can make all elements even
//         arr = new int[n];

//         for (int i = 0; i < n; i++) {
//             arr[i] = nums[i];

//             if (arr[i] % 2 != 0) {
//                 int j = i + 1;

//                 while (j < n) {
//                     if ((arr[i] - nums[j]) % 2 == 0) {
//                         arr[i] = arr[i] - nums[j];
//                     }
//                     j++;
//                 }
//             }
//         }

//         boolean allEven = true;

//         for (int i = 0; i < n; i++) {
//             if (arr[i] % 2 != 0) {
//                 allEven = false;
//                 break;
//             }
//         }

//         return allEven;
//     }
// }
