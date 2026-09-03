class Solution {
    public boolean uniformArray(int[] nums1) {
        int minOdd = Integer.MAX_VALUE;
        int minEven = Integer.MAX_VALUE;

        // Find the smallest odd and smallest even numbers.
        for (int x : nums1) {
            if ((x & 1) == 0) {
                minEven = Math.min(minEven, x);
            } else {
                minOdd = Math.min(minOdd, x);
            }
        }

        boolean canMakeEven = true;
        boolean canMakeOdd = true;

        for (int x : nums1) {
            // Can x be made even?
            if ((x & 1) == 0) {
                // Already even.
            } else {
                // Need to subtract a smaller odd number.
                if (minOdd >= x) {
                    canMakeEven = false;
                }
            }

            // Can x be made odd?
            if ((x & 1) == 1) {
                // Already odd.
            } else {
                // Need to subtract a smaller odd number.
                if (minOdd >= x) {
                    canMakeOdd = false;
                }
            }
        }

        return canMakeEven || canMakeOdd;
    }
}
