package Sorting;

public class Bubble_Sort{
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5};
        // printarr(arr);
        bubble(arr);
        printarr(arr);
    }
    public static void bubble(int[] arr) {
        boolean swapped;
        int n=arr.length;
        for (int pass = 1; pass <= n-1; pass++) {
            swapped = false;
            for (int i = 0; i < n-pass; i++) {
                if(arr[i]>arr[i+1]){
                    int temp=arr[i];
                    arr[i]=arr[i+1];
                    arr[i+1]=temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }
        public static void printarr(int arr[]){
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
        }
} 