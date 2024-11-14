class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        // Binary search on the possible maximum items in a shop
        int left = 1, right = 0;
        
        // Calculate the maximum value of quantities (right bound)
        for (int quantity : quantities) {
            right = Math.max(right, quantity);
        }

        while (left < right) {
            int mid = left + (right - left) / 2;
            int shopsNeeded = 0;

            // Calculate how many shops we need if the maximum per shop is `mid`
            for (int quantity : quantities) {
                shopsNeeded += (quantity + mid - 1) / mid; // Equivalent to Math.ceil(quantity / mid)
            }

            if (shopsNeeded <= n) {
                right = mid; // We can afford a smaller max
            } else {
                left = mid + 1; // We need a larger max
            }
        }

        return left; // The minimal possible maximum items per shop
    }
}
