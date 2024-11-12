import java.util.Arrays;

class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        int max = 0;
        int n = queries.length;
        int arr[] = new int[n];

        // Sort the items based on their price
        Arrays.sort(items, (a, b) -> a[0] - b[0]);

        // Precompute the maximum beauty for each item price
        for (int i = 0; i < items.length; i++) {
            max = Math.max(max, items[i][1]);
            items[i][1] = max; // Store the maximum beauty up to this item
        }

        // Answer the queries using binary search
        for (int j = 0; j < n; j++) {
            int left = 0, right = items.length - 1;
            max = 0;

            // Binary search to find the rightmost item with price <= queries[j]
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (items[mid][0] <= queries[j]) {
                    max = items[mid][1]; // Update max beauty for this query
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            // Store the result for the current query
            arr[j] = max;
        }

        return arr;
    }
}
