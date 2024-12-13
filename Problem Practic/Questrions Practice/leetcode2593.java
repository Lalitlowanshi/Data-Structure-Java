import java.util.*;

class Solution {
    public long findScore(int[] nums) {
        int n = nums.length;
        // Create a list of pairs (value, index) and sort by value, then by index
        List<int[]> indexedNums = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            indexedNums.add(new int[]{nums[i], i});
        }
        indexedNums.sort((a, b) -> a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));

        // Create a boolean array to track marked elements
        boolean[] marked = new boolean[n];
        long score = 0;

        // Iterate through the sorted pairs
        for (int[] pair : indexedNums) {
            int value = pair[0];
            int index = pair[1];

            // If the element is not already marked
            if (!marked[index]) {
                score += value;

                // Mark the current element and its neighbors
                marked[index] = true;
                if (index > 0) {
                    marked[index - 1] = true;
                }
                if (index < n - 1) {
                    marked[index + 1] = true;
                }
            }
        }

        return score;
    }
}
