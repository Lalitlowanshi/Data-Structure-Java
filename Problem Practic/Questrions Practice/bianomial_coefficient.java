public class bianomial_coefficient {
    //formula
    //binomial coefficient = n!/r!*(n-r)!

    public static int fact(int n){
        int prod =1;
        for(int i=1; i<=n; i++){
            prod*=i;
        }
        System.out.println("factorial of number n is :"+ prod);
    return prod;
    }
    public static int Bico(int n, int r){
       int n_fact=fact(n);
       int r_fact=fact(r);
       int nmr_fact=fact(n-r);

       int Bico=n_fact/(r_fact*nmr_fact);
       return Bico;
    }
    public static void main(String[] args) {
     System.out.println(Bico(4, 2)); 
     
    }
}
