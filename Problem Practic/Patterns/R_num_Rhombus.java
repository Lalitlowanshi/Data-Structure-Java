public class R_num_Rhombus{
        public static void main(String[] args) {
            pattern(4);
        }
        public static void pattern(int n) {
        
            for (int Rows = 1; Rows <= 2*n -1; Rows++) {
                int c = Rows > n ? 2 * n - Rows : Rows;

                for (int spaces = 1; spaces <= n-c; spaces++) {
                    System.out.print(" ");
                }
                for (int Cols = c; Cols >= 1; Cols--) {
                    System.out.print(Cols);
                }
                for (int k = 2; k <= c; k++) {
                    System.out.print(k);
                }
                System.out.println();
            }
        }
    }