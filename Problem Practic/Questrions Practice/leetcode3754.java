class Solution {
    public long sumAndMultiply(int n) {
        long num = 0;   
        int sum = 0;

        while (n != 0) {
            int last = n % 10;
            sum += last;

            if (last > 0) {
                num = num * 10 + last;
            }

            n /= 10;  
        }
        long reverse = 0;

        while (num != 0) {
            int digit = (int)(num % 10);
            reverse = reverse * 10 + digit;
            num /= 10;
        }

        long result = reverse * sum;
        return result;
    }
}
