package Recursion;

public class count {
    public static void main(String[] args) {
        // fun(5);
        // funseq(5);
        funBoth(5);
    }
    //for reverse counting of numbers
    public static void fun(int n){
        if (n == 0) {
            return;
        }
        System.out.println(n);
        fun(n-1);
    }
    //right sequence of numbers counting
    public static void funseq(int n){
        if (n == 0) {
            return;
        }
        funseq(n-1);
        System.out.println(n);
    }
    public static void funBoth(int n){
        if (n == 0) {
            return;
        }
        System.out.println(n);
        funBoth(n-1);
        System.out.println(n);
    }
}
