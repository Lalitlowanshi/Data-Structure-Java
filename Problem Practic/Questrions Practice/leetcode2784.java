class Solution {
    public boolean isGood(int[] nums) {
        int n = 0;
        
        // Step 1: find max element
        for (int num : nums) {
            n = Math.max(n, num);
        }

        // Step 2: check length
        if (nums.length != n + 1) return false;

        // Step 3: frequency array
        int[] freq = new int[n + 1];

        for (int num : nums) {
            if (num > n) return false;
            freq[num]++;
        }

        // Step 4: validate
        for (int i = 1; i < n; i++) {
            if (freq[i] != 1) return false;
        }

        return freq[n] == 2;
    }
}
