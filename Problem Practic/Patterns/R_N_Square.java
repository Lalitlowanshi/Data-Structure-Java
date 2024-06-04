public class R_N_Square {
        public static void main(String[] args) {
            pattern(4);
        }
    
        public static void pattern(int n) {
            int Original_n = n + 1;
            n = n*2;
            for (int i = 1; i < n; i++) {
                for (int j = 1; j < n; j++) {
                    int atEveryIndex =Original_n - Math.min(Math.min( i , j ),Math.min ( n-i , n-j ));
                    System.out.print(atEveryIndex + " ");
                }
                System.out.println();
            }
        }
    }
