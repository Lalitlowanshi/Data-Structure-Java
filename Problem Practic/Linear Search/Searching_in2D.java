import java.util.Arrays;

public class Searching_in2D {
    public static void main(String[] args) {
        int [][] arr = {
            {1,2,3},
            {5,6,45},
            {86,9,8,4},
            {7,10}
        };
        int target = 10;
        int[] ans = search(arr, target);
        System.out.println(Arrays.toString(ans));
    }
    public static int [] search(int [][] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j]== target) {
                    return new int []{i,j};
                }
            }
        }
        return new int []{-1,-1};
    }
}
