class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        // Create the grid
        char[][] grid = new char[m][n];
        
        // Mark guards and walls in the grid
        for (int[] guard : guards) {
            grid[guard[0]][guard[1]] = 'G'; // Guard
        }
        for (int[] wall : walls) {
            grid[wall[0]][wall[1]] = 'W'; // Wall
        }
        
        // Mark guarded cells
        for (int[] guard : guards) {
            int x = guard[0];
            int y = guard[1];
            
            // Move up
            for (int i = x - 1; i >= 0; i--) {
                if (grid[i][y] == 'W' || grid[i][y] == 'G') break;
                grid[i][y] = 'X';
            }
            
            // Move down
            for (int i = x + 1; i < m; i++) {
                if (grid[i][y] == 'W' || grid[i][y] == 'G') break;
                grid[i][y] = 'X';
            }
            
            // Move left
            for (int j = y - 1; j >= 0; j--) {
                if (grid[x][j] == 'W' || grid[x][j] == 'G') break;
                grid[x][j] = 'X';
            }
            
            // Move right
            for (int j = y + 1; j < n; j++) {
                if (grid[x][j] == 'W' || grid[x][j] == 'G') break;
                grid[x][j] = 'X';
            }
        }
        
        // Count unguarded cells
        int unguardedCount = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    unguardedCount++;
                }
            }
        }
        
        return unguardedCount;
    }

}
