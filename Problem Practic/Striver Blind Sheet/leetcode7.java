class Solution {
    public int reverse(int x) {
        boolean trigger = false;
        int temp = 0;
        long num = 0;

        if(x < 0){
            trigger = true;
            x *= -1;
        }

        while(x != 0){
           temp = x % 10;
           x /= 10;

            // overflow check
            if (num > Integer.MAX_VALUE / 10 ||
               (num == Integer.MAX_VALUE / 10 && temp > 7))
                return 0;

            if (num < Integer.MIN_VALUE / 10 ||
               (num == Integer.MIN_VALUE / 10 && temp < -8))
                return 0;
                
           num = num*10 + temp;
        }
        if(trigger){
            num *= -1;
        }
        return (int)num;
    }
}
