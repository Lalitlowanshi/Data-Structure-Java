import java.util.*;

public class Solution {
    public int maxTwoEvents(int[][] events) {
        // Sort events by end time
        Arrays.sort(events, (a, b) -> Integer.compare(a[1], b[1]));

        // Array to store the maximum value at each index
        int n = events.length;
        int[] maxValue = new int[n];
        maxValue[0] = events[0][2];
        
        // Fill the maxValue array with the max value so far
        for (int i = 1; i < n; i++) {
            maxValue[i] = Math.max(maxValue[i - 1], events[i][2]);
        }

        int maxSum = 0;

        // Iterate through the events and calculate the maximum sum
        for (int i = 0; i < n; i++) {
            int currentValue = events[i][2];
            maxSum = Math.max(maxSum, currentValue); // Case: Only one event

            // Find the last non-overlapping event using binary search
            int low = 0, high = i - 1, idx = -1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (events[mid][1] < events[i][0]) {
                    idx = mid;
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

            // Case: Two non-overlapping events
            if (idx != -1) {
                maxSum = Math.max(maxSum, currentValue + maxValue[idx]);
            }
        }

        return maxSum;
    }
}
