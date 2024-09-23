package Leetcode;
import java.util.ArrayList;
import java.util.List;
public class leetcode440 {


    public static int findKthNumber(int n, int k) {
        List<Integer> list = new ArrayList<>();
        
        // Loop starting from 1 (not 0)
        for (int i = 1; i < 10; i++) {
            dfs(i, n, list);
        }

        // Return the Kth element (0-indexed, so subtract 1)
        return list.get(k - 1);
    }

    // Depth First Search (DFS) helper method
    public static void dfs(int current, int n, List<Integer> list) {
        if (current > n) {
            return;
        }
        
        // Add the current number to the list
        list.add(current);
        
        // Recursively generate next lexicographical numbers
        for (int i = 0; i < 10; i++) {
            int num = current * 10 + i;
            if (num > n) {
                return;
            }
            dfs(num, n, list);
        }
    }


    public static void main(String[] args) {
        System.out.println(findKthNumber(13, 2));
    }
}
