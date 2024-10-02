import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
public class leetcode1331 {
    public static void main(String[] args) {
        
    }
        public int[] arrayRankTransform(int[] arr) {
            int n = arr.length;
            ArrayList<Integer> indexArr = new ArrayList<>();
            for(int i=0; i<n; i++){
                indexArr.add(i);
            }
            Collections.sort(indexArr, new Comparator<Integer>(){
                public int compare(Integer x, Integer y){
                    return arr[x] - arr[y];
                }
            });
            int rank = 0;
            int prev = Integer.MAX_VALUE;
            int res [] = new int [n];
            for(int index : indexArr){
                if(prev != arr[index]){
                    prev = arr[index];
                    rank++;
                }
                res[index] = rank;
            }
            return res;
        }
}