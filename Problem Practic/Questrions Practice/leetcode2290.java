import java.util.*;

class Solution {

    public int minimumObstacles(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        // Priority Queue: stores {row, col, obstaclesRemoved}
        Deque<int[]> deque = new ArrayDeque<>();
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        
        // Distance array to track the minimum obstacles removed to reach each cell
        int[][] distance = new int[m][n];
        for (int[] row : distance) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        distance[0][0] = 0;

        // Start BFS from the top-left corner
        deque.offerFirst(new int[]{0, 0, 0});
        
        while (!deque.isEmpty()) {
            int[] current = deque.pollFirst();
            int row = current[0], col = current[1], obstaclesRemoved = current[2];

            // Explore neighbors
            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                // Check boundaries
                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n) {
                    int newObstaclesRemoved = obstaclesRemoved + grid[newRow][newCol];

                    // If we found a better way to reach (newRow, newCol), update and proceed
                    if (newObstaclesRemoved < distance[newRow][newCol]) {
                        distance[newRow][newCol] = newObstaclesRemoved;

                        // Prioritize cells with fewer obstacles removed
                        if (grid[newRow][newCol] == 1) {
                            deque.offerLast(new int[]{newRow, newCol, newObstaclesRemoved});
                        } else {
                            deque.offerFirst(new int[]{newRow, newCol, newObstaclesRemoved});
                        }
                    }
                }
            }
        }

        // Return the minimum obstacles removed to reach the bottom-right corner
        return distance[m - 1][n - 1];
    }
}
