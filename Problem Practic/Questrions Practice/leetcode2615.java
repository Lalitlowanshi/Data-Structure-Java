import java.util.*;

class Solution {
    public long[] distance(int[] nums) {

        int n = nums.length;
        long[] ans = new long[n];

        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        // store indices
        for(int i = 0; i < n; i++) {
            map.putIfAbsent(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }

        for(ArrayList<Integer> list : map.values()) {

            int size = list.size();

            long[] prefix = new long[size];

            prefix[0] = list.get(0);

            for(int i = 1; i < size; i++) {
                prefix[i] = prefix[i - 1] + list.get(i);
            }

            for(int i = 0; i < size; i++) {

                int curr = list.get(i);

                long left = 0;
                long right = 0;

                if(i > 0) {
                    left = (long)curr * i - prefix[i - 1];
                }

                if(i < size - 1) {
                    right = (prefix[size - 1] - prefix[i]) 
                            - (long)curr * (size - i - 1);
                }

                ans[curr] = left + right;
            }
        }

        return ans;
    }
}




// Time Limit Exceeded (TLE)............

// class Solution {
//     public long[] distance(int[] nums) {
//         int n = nums.length;
//         long [] ans = new long[n];
//         int idx = 0;

//         for(int i=0; i<n; i++){
//             long sum = 0;
//             for(int j=0; j<n; j++){
//                 if(i == j) continue;
//                 if(nums[i] == nums[j]){
//                     if(j-i < 0){
//                         // sum += -1*(j-i);
//                         sum -= (j-i);
//                     }
//                     else{
//                         sum += (j-i);
//                     }
//                 }
//             }
//             ans[idx++] = sum;
//         }
//         return ans;
//     }
// }
