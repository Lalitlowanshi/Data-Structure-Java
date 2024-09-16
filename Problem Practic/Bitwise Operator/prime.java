public class prime {
    public static void main(String[] args) {
        int n = 20;
        for (int i = 2; i <= n; i++) {
            System.out.println(i + "  " +isprime(i));
        }
    }
    public static boolean isprime(int n){
        if (n <= 1) {
            return false;
        }

        int c = 2;
        while (c * c <= n) { //like (c <= sqrt(n)), just squaring both sides
            if (n % c == 0) {
                return false;
            }
            c++;
        }
        return true;
    }
}
