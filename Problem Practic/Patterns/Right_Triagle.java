public class Right_Triagle{
    public static void main(String[] args) {
        Pattern(6);
    }
    public static void Pattern(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        
    }
}