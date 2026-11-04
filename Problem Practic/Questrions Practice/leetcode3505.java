
import java.util.*;

class Solution {

    class WindowMedian {
        TreeMap<Integer, Integer> lower = new TreeMap<>();
        TreeMap<Integer, Integer> upper = new TreeMap<>();

        int lowerSize = 0, upperSize = 0;
        long lowerSum = 0, upperSum = 0;

        void add(int num) {
            if (lower.isEmpty() || num <= lower.lastKey()) {
                lower.merge(num, 1, Integer::sum);
                lowerSize++;
                lowerSum += num;
            } else {
                upper.merge(num, 1, Integer::sum);
                upperSize++;
                upperSum += num;
            }
            balance();
        }

        void remove(int num) {
            if (lower.containsKey(num)) {
                erase(lower, num);
                lowerSize--;
                lowerSum -= num;
            } else {
                erase(upper, num);
                upperSize--;
                upperSum -= num;
            }
            balance();
        }

        void erase(TreeMap<Integer, Integer> map, int num) {
            int count = map.get(num);
            if (count == 1) {
                map.remove(num);
            } else {
                map.put(num, count - 1);
            }
        }

        void balance() {
            int target = (lowerSize + upperSize + 1) / 2;

            while (lowerSize > target) {
                int val = lower.lastKey();
                erase(lower, val);
                lowerSize--;
                lowerSum -= val;

                upper.merge(val, 1, Integer::sum);
                upperSize++;
                upperSum += val;
            }

            while (lowerSize < target) {
                int val = upper.firstKey();
                erase(upper, val);
                upperSize--;
                upperSum -= val;

                lower.merge(val, 1, Integer::sum);
                lowerSize++;
                lowerSum += val;
            }
        }

        long getCost() {
            long median = lower.lastKey();

            return median * lowerSize - lowerSum
                 + upperSum - median * upperSize;
        }
    }

    public long minOperations(int[] nums, int x, int k) {

        int n = nums.length;

        // Step 1: Calculate cost of every window
        long[] cost = new long[n - x + 1];

        WindowMedian wm = new WindowMedian();

        for (int i = 0; i < x; i++) {
            wm.add(nums[i]);
        }

        cost[0] = wm.getCost();

        for (int i = x; i < n; i++) {
            wm.remove(nums[i - x]);
            wm.add(nums[i]);

            cost[i - x + 1] = wm.getCost();
        }

        // Step 2: Dynamic Programming
        long INF = Long.MAX_VALUE / 4;

        long[][] dp = new long[k + 1][n + 1];

        for (int i = 0; i <= k; i++) {
            Arrays.fill(dp[i], INF);
        }

        // Zero subarrays require zero operations
        for (int i = 0; i <= n; i++) {
            dp[0][i] = 0;
        }

        // Step 3: Choose k non-overlapping windows
        for (int t = 1; t <= k; t++) {

            for (int i = 1; i <= n; i++) {

                // Skip current position
                dp[t][i] = dp[t][i - 1];

                // Select window ending at i - 1
                if (i >= x && dp[t - 1][i - x] != INF) {

                    long take = dp[t - 1][i - x]
                              + cost[i - x];

                    dp[t][i] = Math.min(dp[t][i], take);
                }
            }
        }

        return dp[k][n];
    }
}
