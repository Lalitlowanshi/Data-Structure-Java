
import java.util.*;

class Solution {
    public long countNonDecreasingSubarrays(int[] nums, int k) {

        int n = nums.length;

        long ans = 0;
        long cost = 0;

        // Each pair stores {value, count}
        Deque<int[]> dq = new ArrayDeque<>();

        int j = n - 1;

        // Traverse from right to left
        for (int i = n - 1; i >= 0; i--) {

            int num = nums[i];
            int count = 1;

            // Merge smaller groups into the current group
            while (!dq.isEmpty() && dq.peekLast()[0] < num) {

                int[] last = dq.pollLast();

                int nextNum = last[0];
                int nextCount = last[1];

                count += nextCount;

                cost += (long) (num - nextNum) * nextCount;
            }

            // Add the current group
            dq.offerLast(new int[]{num, count});

            // Shrink the window if cost exceeds k
            while (cost > k) {

                int[] first = dq.pollFirst();

                int rightmostNum = first[0];
                int rightmostCount = first[1];

                // Remove the rightmost original element
                cost -= rightmostNum - nums[j];

                j--;

                // Restore the remaining part of the group
                if (rightmostCount > 1) {
                    dq.offerFirst(
                        new int[]{rightmostNum, rightmostCount - 1}
                    );
                }
            }

            // Count all valid subarrays ending at j
            ans += j - i + 1;
        }

        return ans;
    }
}
