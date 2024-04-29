package Binary_search_in_2D_Array;

import java.util.Arrays;

class sorted_matrix {
    public static void main(String[] args) {
        int arr [][]={
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            {13,14,15,16}
        };
        int target =17;
        System.out.println(Arrays.toString(search(arr, target)));
    }
    // search in the row provided between the columns provided
    public static int [] Binary_search(int[][]matrix, int row, int cStart, int cEnd, int target){
        while (cStart <= cEnd) {
            int mid = cStart+(cEnd-cStart)/2;
            
            if (matrix[row][mid] == target) {
                return new int[]{row,mid};
            }
                        
            if (matrix[row][mid] < target) {
                cStart= mid+1;
            }
            else{
                cEnd = mid-1;
            }
        }
        return new int[]{-1,-1};
    }

    public static int[] search (int [][]matrix , int target){
        int rows = matrix.length;
        int cols = matrix[0].length;
        if (rows == 1) {
            return Binary_search(matrix, 0, 0, cols-1, target);
        }
         int rStart = 0;
         int rEnd = rows-1;
         int cMid = cols /2;

        // run the loop till two rows are remaining
        while (rStart < (rEnd-1)) {//while this is true it will have more than two rows
            int mid = rStart +(rEnd-rStart)/2;

            if (matrix [mid][cMid] == target) {
                return new int [] {mid,cMid};
            }
            if (matrix[mid] [cMid] < target) {
                rStart = mid;
            }
            else{
                rEnd = mid;
            }
        }
        // now we have two rows..
        //check wether the target is in the columns of the 2 rows 
        if (matrix [rStart][cMid] == target) {
            return new int[] {rStart,cMid};
        }

        if (matrix [rStart+1][cMid] == target) {
            return new int[] {rStart+1,cMid};
        }

        // search in first(1st) half 
        if (target  <= matrix [rStart] [cMid-1]) {
            return Binary_search(matrix,rStart,0,cMid-1,target);
        }
        // search in second(2nd) half
        if (target  >= matrix [rStart] [cMid+1] && target <= matrix[rStart][cols-1]) {
            return Binary_search(matrix,rStart,cMid+1,cols-1,target);

        }
        // search in third(3rd) half 
        if (target  <= matrix [rStart+1] [cMid-1] && target >= matrix [rStart][0]) {
            return Binary_search(matrix,rStart+1,0,cMid-1,target);

        }
        // search in forth(4th) half
        if (target  >= matrix [rStart+1] [cMid+1]) {//else ...
            return Binary_search(matrix,rStart+1,cMid+1,cols-1,target);

        }
        return new int []{-1,-1};

    }
    
}