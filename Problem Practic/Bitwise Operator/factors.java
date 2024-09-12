import java.util.ArrayList;

public class factors {
    public static void main(String[] args) {
        factors1(20);
        factors2(20);
        factors3(20);
    }
    // this is O(n)
    public static void factors1(int n){
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }


    // time complexity is O(sqrt(n))
    public static void factors2(int n){
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                if (n/i == i) {
                    System.out.print(i + " ");
                }
                else{
                    System.out.print(i + " " + n/i + " ");
                }
            }
        }
        System.out.println();
    }


    //both time and space complexity will be O(sqrt(n))
    //we are print element in sorted order...
    public static void factors3(int n){
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                if (n/i == i) {
                    System.out.print(i + " ");
                }
                else{
                    System.out.print(i + " ");
                    list.add(n/i);
                }
            }
        }
        for (int i = list.size()-1; i >= 0; i--) {
            System.out.print(list.get(i) + " ");
            
        }
    }
}
