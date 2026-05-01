class Solution {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        
        long sum = 0;
        long f0 = 0;
        
        // Step 1: sum and F(0)
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            f0 += (long)i * nums[i];
        }
        
        long max = f0;
        long prev = f0;
        
        // Step 2: use relation
        for (int k = 1; k < n; k++) {
            long curr = prev + sum - (long)n * nums[n - k];
            max = Math.max(max, curr);
            prev = curr;
        }
        
        return (int) max;
    }
}
