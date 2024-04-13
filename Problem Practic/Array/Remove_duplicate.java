package Questions;

public class Remove_duplicate {
    public static void main(String[] args) {
        int [] a= {0,0,0,1,1,1,2,2,2,3,3,3,4,4,4,4,5,5,5};
        Remover(a);
    }
    public static void Remover(int [] a) {
        int count =0;
        for (int i = 0; i < a.length-1; i++) {
            if(a[i]!=a[i+1]){
                System.out.print(a[i]+" "); 
                count = count +1;                   
                }
            }
            System.out.println(a[a.length-1]);
            System.out.println(count);
                }
    }

