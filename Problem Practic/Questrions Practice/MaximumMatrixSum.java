class Solution {
public long maxMatrixSum(int[][] matrix) {
        int n = matrix.length;
        long totalSum = 0; // To store the total absolute sum of the matrix.
        int minAbsValue = Integer.MAX_VALUE; // To find the smallest absolute value in the matrix.
        int negativeCount = 0; // To count the number of negative elements.

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int val = matrix[i][j];
                totalSum += Math.abs(val); // Add absolute value to total sum.
                minAbsValue = Math.min(minAbsValue, Math.abs(val)); // Track the smallest absolute value.
                if (val < 0) {
                    negativeCount++; // Count negative numbers.
                }
            }
        }
        if (negativeCount % 2 != 0) {
            totalSum -= 2 * minAbsValue;
        }

        return totalSum;
    }
}
