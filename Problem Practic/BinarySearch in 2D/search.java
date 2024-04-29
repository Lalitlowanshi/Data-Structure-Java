package Binary_search_in_2D_Array;

import java.util.Arrays;

public class search {
    public static void main(String[] args) {
        int [][] a = { {10,20,30,40},
                       {15,25,35,45},
                       {28,29,37,49},
                       {33,34,38,50}};
        int target = 37;
        int [] ans = B_search(a,target);
        System.out.println(Arrays.toString(ans));

    }
    public static int [] B_search(int [][] matrix, int target) {
        int r = 0;
        int c = matrix.length-1;
        while (r < matrix.length && c >= 0) {
            if (matrix[r][c] == target) {
                return new int[]{r,c};
            }
            if (matrix[r][c] < target) {
                r++;
            }
            else{
                c--;
            }
        }
        return new int[]{-1,-1};
    }
}
