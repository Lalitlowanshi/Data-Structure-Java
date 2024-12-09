class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] parityDiff = new int[n - 1];
        
        // Step 1: Compute parityDiff array
        for (int i = 0; i < n - 1; i++) {
            parityDiff[i] = (nums[i] % 2 != nums[i + 1] % 2) ? 1 : 0;
        }
        
        // Step 2: Compute prefix sum of parityDiff
        int[] prefixSum = new int[n];
        for (int i = 0; i < n - 1; i++) {
            prefixSum[i + 1] = prefixSum[i] + parityDiff[i];
        }
        
        // Step 3: Process each query
        boolean[] results = new boolean[queries.length];
        for (int q = 0; q < queries.length; q++) {
            int from = queries[q][0];
            int to = queries[q][1];
            
            if (from == to) {
                // Single element subarray is always special
                results[q] = true;
            } else {
                int diffCount = prefixSum[to] - prefixSum[from];
                results[q] = diffCount == (to - from);
            }
        }
        
        return results;
    }
}
