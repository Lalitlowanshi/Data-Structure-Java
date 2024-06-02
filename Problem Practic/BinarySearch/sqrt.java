// https://leetcode.com/problems/sqrtx/description/

public class sqrt{
    public static void main(String[] args) {
    System.out.println(mySqrt(4));
    }
    public static int mySqrt(int x) {
        if(x <= 1){
            return x;
        }
        long i =1;
        long sq =1;
        while(x >= sq){
            i++;
            sq= i*i;
        }
        return (int) (i-1);
    }
}