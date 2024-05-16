package Sorting;

import java.util.Arrays;

// we can apply this sorting technique
// when given number is of sequence of 1 to n.(continuos)
// like 1,2,3,4,5.....
public class cycle_sort{
    public static void main(String[] args) {
        int [] arr= {5,4,2,1,3};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void sort(int [] a){
        int i = 0;
        while (i < a.length) {
            int correct = a[i] - 1;
            if (a[i] != a[correct]) {
                swap(a,i, correct);
            }
            else{
                i++;
            }
        }
    }
    public static void swap(int [] a ,int first ,  int second) {
        int temp = a[first];
        a[first] = a[second];
        a[second] = temp;
    }
}