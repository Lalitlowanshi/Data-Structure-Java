class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int n = nums.length;
        int maxK = (1 << maximumBit) - 1; // Maximum value with 'maximumBit' bits
        int xor = 0;
        int[] arr = new int[n];

        // Calculate the prefix XOR for the entire array
        for (int num : nums) {
            xor ^= num;
        }

        int a = 0;

        // Iterate from the end of the array to fill the result
        for (int i = n - 1; i >= 0; i--) {
            arr[a] = xor ^ maxK; // XOR with the maximum value
            xor ^= nums[i];      // Remove the current element from the prefix XOR
            a++;
        }

        return arr;
    }
}
