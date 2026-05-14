import java.util.Scanner;

public class Armstrong {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt();
        System.out.println(isarmstrong(n));
        //want to print all armstrom numbers
        for (int i = 0; i < 1000; i++) {
            if(isarmstrong(i)){
                System.out.println(i);
            }
        }
    }
    public static boolean isarmstrong(int n) {
        int original =n;
        int count= 0;
        while (n>0){
        int rem = n%10;
        n = n/10;
        count = count + rem*rem*rem;
        }
        // if(original==count){
        //     return true;
        // }
        // return false;
        return original == count;
    }
}
