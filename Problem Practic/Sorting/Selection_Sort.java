package Sorting;
public class Selection_Sort {
    public static void main(String[] args) {
        int [] a ={5,4,3,2,1};
        sort(a);
        print(a);
    }
    public static void sort(int [] a) {
        
        for (int i = 0; i < a.length-1; i++) {
           int key=i;
            for (int j = i+1; j < a.length; j++) {
                if(a[j] < a[key]){
                    key=j;
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
