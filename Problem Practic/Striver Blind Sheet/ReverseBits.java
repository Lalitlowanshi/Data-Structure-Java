public class Solution {
    // You need to treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result <<= 1;      // Left shift result by 1 bit
            result |= (n & 1); // Append last bit of n to result
            n >>>= 1;          // Right shift n (unsigned shift)
        }
        return result;
    }
}
