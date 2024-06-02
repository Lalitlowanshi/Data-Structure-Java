public class Rhombus{
    public static void main(String[] args) {
        Pattern(5);
    }
    public static void Pattern(int n) {
        for (int i = 1; i <=2*n; i++) {
            int total_cols_inRow = i > n ? (2*n - i) : i;

            int spaces = n-total_cols_inRow;
            for (int sp = 0; sp < spaces; sp++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= total_cols_inRow; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        
    } 
}