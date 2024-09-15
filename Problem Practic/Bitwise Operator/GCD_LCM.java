public class GCD_LCM {
    public static void main(String[] args) {
        System.out.println(gcd(7, 10));
        System.out.println(lcm(10, 15));
    }
    public static int gcd(int a, int b) {
        if (a == 0) {
            return b;
        }
        return gcd(b%a, a);
    }

    public static int lcm (int a, int b){
        int d = gcd(a,b);
        return (a*b)/d;
    }
}
