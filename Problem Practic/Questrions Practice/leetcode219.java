
import java.util.*;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {

            if (set.contains(nums[i])) {
                return true;
            }

            set.add(nums[i]);

            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }

        return false;
    }
}



// Wrong Solution (Minor Logical Mistakes)...

// class Solution {
//     public boolean containsNearbyDuplicate(int[] nums, int k) {
//         int n = nums.length;
//         Set<Integer> set = new HashSet<>();
//         int j = 0;
//         for(int i=0; i<n; i++){
//             while(j <= i+k && i+k < n){
//                 if(set.contains(nums[j])){
//                     return true;
//                 }
//                 set.add(nums[j]);
//                 j++;
//             }
//             set.remove(nums[i]);
//         }
//         return false;
//     }
// }
