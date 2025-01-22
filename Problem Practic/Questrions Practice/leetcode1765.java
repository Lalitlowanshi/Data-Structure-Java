import java.util.*;

class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length, n = isWater[0].length;
        int[][] height = new int[m][n];

        // Initialize the height matrix, where water cells are marked as 0
        // and land cells are initialized with -1 (unvisited)
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isWater[i][j] == 1) {
                    height[i][j] = 0;
                } else {
                    height[i][j] = -1;
                }
            }
        }

        // BFS to propagate the heights from the water cells
        Queue<int[]> queue = new LinkedList<>();

        // Add all water cells to the queue
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isWater[i][j] == 1) {
                    queue.offer(new int[] { i, j });
                }
            }
        }

        // Directions for North, South, East, West
        int[] dirs = { -1, 0, 1, 0, -1 };

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1];

            // Check all 4 adjacent cells (N, S, E, W)
            for (int i = 0; i < 4; i++) {
                int nx = x + dirs[i];
                int ny = y + dirs[i + 1];

                // Skip out-of-bound cells or already assigned land cells
                if (nx < 0 || ny < 0 || nx >= m || ny >= n || height[nx][ny] != -1) {
                    continue;
                }

                // Assign the height based on the adjacent water cell
                height[nx][ny] = height[x][y] + 1;
                queue.offer(new int[] { nx, ny });
            }
        }

        return height;
    }
}
