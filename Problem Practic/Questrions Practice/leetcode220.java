import java.util.*;

class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        TreeMap<Long, Integer> map = new TreeMap<>();

        for (int i = 0; i < nums.length; i++) {

            if (i > indexDiff) {
                long old = nums[i - indexDiff - 1];

                map.put(old, map.get(old) - 1);

                if (map.get(old) == 0) {
                    map.remove(old);
                }
            }

            long x = nums[i];
            Long candidate = map.ceilingKey(x - valueDiff);

            if (candidate != null && candidate <= x + valueDiff) {
                return true;
            }

            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        return false;
    }
}

// class Solution {
//     public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
//         for (int i = 0; i < nums.length; i++) {
//             for (int j = i + 1; j < nums.length && j - i <= indexDiff; j++) {
//                 if (Math.abs((long) nums[i] - nums[j]) <= valueDiff) {
//                     return true;
//                 }
//             }
//         }
//         return false;
//     }
// }
