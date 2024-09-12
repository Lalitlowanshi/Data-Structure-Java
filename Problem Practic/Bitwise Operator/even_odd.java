public class even_odd {
public static void main(String[] args) {
   
    System.out.println( check_even_odd(11));
}
public static boolean check_even_odd(int n) {
    // if ((n & 1) == 1) {
    //     System.out.println("odd");
    // }
    // else{
    //     System.out.println("even");
    // }
    return (n & 1) == 1;

    // false = even
    // true = odd
}
    
}