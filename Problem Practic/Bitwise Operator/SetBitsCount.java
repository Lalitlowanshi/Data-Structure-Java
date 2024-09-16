public class SetBitsCount {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(Integer.toBinaryString(n));
        
        System.out.println(setBits(n));
    }

    private static int setBits(int n) {
        int count = 0;

        // while (n > 0) {
        //     count++;
        //     n -= (n & (-n));
        // }

        while (n > 0) {
            count ++;
            n =n & (n-1);
        }

        return count;
    }
}









// leetcode
class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
       int a1 [] = new int [queries.length];
        for(int i = 0; i < arr.length; i++){
            int a = 0;

            for(int j = queries[i][0]; j <= queries[i][1]; j++){
                a ^= arr[j]; 
            }
            a1[i] = a;
        }
        return a1;
    }
}
