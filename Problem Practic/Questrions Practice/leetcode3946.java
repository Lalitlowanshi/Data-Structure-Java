
class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int minPrice = Integer.MAX_VALUE;

        int[] free = new int[n];

        // Count free items for each item
        for (int i = 0; i < n; i++) {
            minPrice = Math.min(minPrice, items[i][1]);

            for (int j = 0; j < n; j++) {
                if (i != j && items[j][0] % items[i][0] == 0) {
                    free[i]++;
                }
            }
        }

        // 0/1 Knapsack
        int[] dp = new int[budget + 1];

        for (int i = 0; i < n; i++) {
            int price = items[i][1];
            int value = free[i] + 1;

            for (int j = budget; j >= price; j--) {
                dp[j] = Math.max(dp[j], dp[j - price] + value);
            }
        }

        int ans = 0;

        // Buy cheapest items with remaining budget
        for (int j = 0; j <= budget; j++) {
            ans = Math.max(ans, dp[j] + (budget - j) / minPrice);
        }

        return ans;
    }
}
