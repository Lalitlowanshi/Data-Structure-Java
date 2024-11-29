import java.util.*;
class Solution {

    private static final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    
    public int minimumTime(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        // If the initial move to (0, 1) or (1, 0) is blocked, return -1
        if (grid[0][1] > 1 && grid[1][0] > 1) {
            return -1;
        }

        // Priority Queue: {time, x, y}
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, 0, 0}); // Start from (0, 0) at time 0
        
        // Visited set to avoid revisiting cells unnecessarily
        boolean[][] visited = new boolean[m][n];
        
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int time = current[0], x = current[1], y = current[2];
            
            // If already visited, skip
            if (visited[x][y]) continue;
            visited[x][y] = true;
            
            // If we reached the bottom-right cell, return the time
            if (x == m - 1 && y == n - 1) return time;

            // Explore neighbors
            for (int[] dir : DIRECTIONS) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && !visited[nx][ny]) {
                    // Calculate the earliest valid time to move to (nx, ny)
                    int waitTime = Math.max(0, grid[nx][ny] - (time + 1));
                    int nextTime = time + 1 + ((waitTime % 2 == 0) ? waitTime : waitTime + 1);
                    pq.offer(new int[]{nextTime, nx, ny});
                }
            }
        }
        
        return -1; // If the bottom-right cell is not reachable
    }
}
