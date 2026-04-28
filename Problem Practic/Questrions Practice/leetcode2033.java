class Solution {
    public int minOperations(int[][] grid, int x) {
        List<Integer> list = new ArrayList<>();

        // Flatten
        for (int[] row : grid) {
            for (int num : row) {
                list.add(num);
            }
        }

        // Check possibility
        int rem = list.get(0) % x;
        for (int num : list) {
            if (num % x != rem) return -1;
        }

        // Sort
        Collections.sort(list);

        // Median
        int median = list.get(list.size() / 2);

        // Count operations
        int ans = 0;
        for (int num : list) {
            ans += Math.abs(num - median) / x;
        }

        return ans;
    }
}
