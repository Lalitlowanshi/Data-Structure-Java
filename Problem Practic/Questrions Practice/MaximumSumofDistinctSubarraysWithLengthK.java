import java.util.HashSet;
import java.util.Set;

class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long maxSum = 0; // To track the maximum sum
        long currentSum = 0; // To track the current sum of the window
        Set<Integer> window = new HashSet<>(); // To ensure all elements in the window are unique
        
        int start = 0; // Start index of the sliding window

        for (int end = 0; end < nums.length; end++) {
            // If the current element is a duplicate in the window, shrink the window
            while (window.contains(nums[end])) {
                currentSum -= nums[start]; // Remove the leftmost element from the sum
                window.remove(nums[start]); // Remove it from the set
                start++; // Move the start of the window
            }

            // Add the current element to the window
            currentSum += nums[end];
            window.add(nums[end]);

            // If the window size equals k, check for maximum and slide the window
            if (end - start + 1 == k) {
                maxSum = Math.max(maxSum, currentSum); // Update the maximum sum
                currentSum -= nums[start]; // Slide the window by removing the leftmost element
                window.remove(nums[start]);
                start++;
            }
        }

        return maxSum;
    }
}

// class Solution {
//     public long maximumSubarraySum(int[] nums, int k) {
//         long max = 0;
//         for(int i=0; i<=nums.length-k; i++){
//             boolean hasDuplicate = false; 
//             long sum = 0;
//             for(int j=i; j<k+i; j++){
//                 for(int m=i; m<j; m++){
//                     if(nums[j] == nums[m]){
//                         hasDuplicate = true;
//                         break;
//                     }
//                 }
//                 if(hasDuplicate) break;
//                 sum += nums[j];

//             }
//             if(!hasDuplicate){
//                 if(max < sum){
//                     max = sum;
//                 }
//             }
//         }
//         return max;
//     }
// }

