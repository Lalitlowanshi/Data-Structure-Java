class Solution {
    public int findChampion(int n, int[][] edges) {
        int[] indeg = new int[n];
        for (int[] edge : edges) {
            indeg[edge[1]]++; // Increment in-degree for the destination node
        }
        
        int ans = -1, count = 0;
        for (int i = 0; i < n; ++i) {
            if (indeg[i] == 0) {
                count++; // Count nodes with zero in-degree
                ans = i; // Potential champion
            }
        }
        
        return count == 1 ? ans : -1; // Return champion if unique, else -1
    }
}
