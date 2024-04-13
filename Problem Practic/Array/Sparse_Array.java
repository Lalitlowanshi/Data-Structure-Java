package Questions;

public class Sparse_Array {
    public static void main(String[] args) {
        String [] array ={"a","a","b","dd"};
        String [] Query ={"a","b","e"};
        sparse(array,Query);
    }
    public static void sparse(String [] a, String [] b) {
        System.out.print("[");
        for (int i = 0; i < b.length; i++) {
            int count=0;

            for (int j = 0; j < a.length; j++) {
                
                if (b[i]==a[j]) {
                   count = count +1;
                }
            }
            System.out.print(count +",");
        }
        System.out.print("]");
    }
}
