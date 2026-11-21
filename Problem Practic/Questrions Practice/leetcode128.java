class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            set.add(nums[i]);
        }

        if (set.isEmpty()) {
            return 0;
        }

        Iterator<Integer> it = set.iterator();

        int prev = it.next();
        int count = 1;
        int max = 1;

        while (it.hasNext()) {
            int curr = it.next();

            if (curr == prev + 1) {
                count++;
            } else {
                count = 1;
            }

            max = Math.max(max, count);
            prev = curr;
        }

        return max;
    }
}





// import java.util.*;

// class Solution {
//     public int longestConsecutive(int[] nums) {
//         HashSet<Long> set = new HashSet<>();

//         for (int num : nums) {
//             set.add((long) num);
//         }

//         int longest = 0;

//         for (long num : set) {

//             if (!set.contains(num - 1)) {

//                 long current = num;
//                 int count = 1;

//                 while (set.contains(current + 1)) {
//                     current++;
//                     count++;
//                 }

//                 longest = Math.max(longest, count);
//             }
//         }

//         return longest;
//     }
// }
