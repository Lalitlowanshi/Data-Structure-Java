public class R_num_Tri {
    public static void main(String[] args) {
        pattern(5);
    }
    public static void pattern(int n) {
    
        for (int Rows = 1; Rows <= n; Rows++) {
            for (int spaces = 1; spaces <= n-Rows; spaces++) {
                System.out.print(" ");
            }


            for (int Cols = Rows; Cols >= 1; Cols--) {
                System.out.print(Cols);
            }
            for (int k = 2; k <= Rows; k++) {
                System.out.print(k);
            }
            System.out.println();
        }
    }
}

