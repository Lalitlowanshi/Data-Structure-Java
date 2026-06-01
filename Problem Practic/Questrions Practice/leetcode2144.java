import java.util.*;

class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);

        int ans = 0;
        int n = cost.length;

        // Traverse from largest to smallest
        for (int i = n - 1; i >= 0; i -= 3) {
            ans += cost[i]; // largest

            if (i - 1 >= 0) {
                ans += cost[i - 1]; // second largest
            }
            // i-2 is free
        }

        return ans;
    }
}
