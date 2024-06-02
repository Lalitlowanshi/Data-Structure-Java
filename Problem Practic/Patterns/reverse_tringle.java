public class reverse_tringle {
    public static void main(String[] args) {
        Pattern(5);
    }
    public static void Pattern(int n) {
        // for (int i = 0; i < n; i++) {
        //     for (int j = i; j < n; j++) {
        //         System.out.print("*");
        //     }
        //     System.out.println();
        // }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n-i+1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
