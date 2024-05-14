import java.util.Scanner;

public class IsPrime {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean ans = isprime(n);
        System.out.println(ans);
    }
     static boolean isprime(int n) {
        if (n<=1){
        return false;
        }
        int c=2;
        while(c*c<=n){
            if (n%c==0){
                return false;
            }
            c++; 
        }
        if(c*c>n){
            return true;
        }
        return false;
    }
    // return c*c>n;
}
