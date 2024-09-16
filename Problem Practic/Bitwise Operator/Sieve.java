public class Sieve {
    public static void main(String[] args) {
        int n = 40;
        boolean [] prime = new boolean[n+1];
        seive_of_Eratosthenes(n, prime); 
    }

    public static void seive_of_Eratosthenes(int n, boolean [] prime){
        for (int i = 2; i*i < n; i++) {
            if (!prime[i]) {
                for (int j = i*2; j <= n; j+=i) {
                    prime[j] = true;
                }
            }
        }

        for (int i = 2; i < prime.length; i++) {
            if (!prime[i]) {
                System.out.print(i+ " ");
            }
        }
    }
}
