    public class Max_in2D {
    public static void main(String[] args) {
        int [][] arr = {
            {1,2,3},
            {5,6,45},
            {86,99,8,4},
            {7,10}
        };
        // int target = 10;
        int ans = max(arr);
        System.out.println(ans);
    }
    public static int  max(int [][] arr) {
        int temp = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j]> temp) {
                    temp = arr[i][j];
                }
            }
        }
        return temp; 
   }
}

