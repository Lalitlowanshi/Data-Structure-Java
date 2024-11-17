package Recursion;

public class Array_SortedOrNot {
    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5,6};
        System.out.println(sortrd(arr, 0));
    }
    public static boolean sortrd(int [] arr, int index){
        // base condition
        if (index == arr.length-1) {
            return true;
        }
        return arr[index] < arr[index+1] && sortrd(arr, index +1);
    }
}
