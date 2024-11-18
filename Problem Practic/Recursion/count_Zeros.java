package Recursion;

public class count_Zeros {
    public static void main(String[] args) {
        System.out.println(count2(30204));
    }
    // By using Recursion over here..

    public static int count2(int n){
        return helper(n, 0);
    }
    public static int helper(int n, int c){
        if (n == 0) {
            return c;
        }

        int rem = n%10;
        if (rem == 0) {
            return helper(n/10, c+1);
        }
        return helper(n/10, c);
    }




    // Without Recursion, simple solution, BruteForce Approach..

    public static int count(int n){
        int count = 0;
        while (n!=0) {
            int rem = n%10;
            n = n/10;
            if (rem == 0) {
                count ++;
            }
        }
        return count;
    }
}