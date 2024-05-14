public class hollowdiamond {
    public static void diamond(int n) {
        for (int i=1; i<=n; i++){
            for(int j=n-i; j>=1;j--){
            System.out.print(" "); 
        }
        for (int j = 1; j <=2*i-1; j++) {
            if (j==1||j==2*i-1) {
            System.out.print("*");
        }
        else{
            System.out.print(" ");
        }
    }
        System.out.println();
    }
    for (int i = n-1; i >= 1; i--) {
         for(int j=n-i; j>=1;j--){
            System.out.print(" "); 
        }
        for (int j = 1; j <=2*i-1; j++) {
            if (j==1||j==2*i-1) {
            System.out.print("*");
        }
        else{
            System.out.print(" ");
        }
    }
        System.out.println();
        
    }
}
public static void main(String[] args) {
    int n=4;
    diamond(n);
}
}