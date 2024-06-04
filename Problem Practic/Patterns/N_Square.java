public class N_Square {
    public static void main(String[] args) {
        pattern(5);
    }

    public static void pattern(int n) {
            n = n*2;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                int atEveryIndex = Math.min(Math.min( i , j ),Math.min ( n-i , n-j ));
                System.out.print(atEveryIndex + " ");
            }
            System.out.println();
        }
    }
}
