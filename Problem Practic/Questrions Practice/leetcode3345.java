class Solution {
    public int smallestNumber(int n, int t) {

        while (true) {
            int product = 1;
            int a = n;

            if (a == 0) {
                product = 0;
            } else {
                while (a != 0) {
                    product *= (a % 10);
                    a /= 10;
                }
            }

            if (product % t == 0)
                return n;

            n++;
        }
    }
}
