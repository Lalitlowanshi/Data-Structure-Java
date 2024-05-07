package Sorting;

public class Insertion_Sort {
    public static void main(String[] args) {
        int [] a ={5,4,1,3,2};
        sort(a);
        print(a);
    }
    public static void sort(int [] a) {
        for (int i = 0; i < a.length-1; i++) {
            int key=i;
             for (int j = i+1; j > 0; j--) {
                 if(a[j] < a[key]){
                     key=j;
                     key--;
                 }
                 //swapping
                int minvalue = a[key];
                  a[key] = a[i];
                    a[i] = minvalue;
             }
         }
    }
    public static void print (int [] a) {
        for (int i = 0; i < a.length; i++) {
        System.out.print(a[i] +" ");
        }
    }
}
