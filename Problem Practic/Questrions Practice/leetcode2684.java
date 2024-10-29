public class Solution {
    private int[][] directions = {{0, 1}, {1, 1}, {-1, 1}}; // Right, Down-Right Diagonal, Up-Right Diagonal
    private int rows, cols;
    private Integer[][] memo;

    public int maxMoves(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        memo = new Integer[rows][cols];
        int maxMoves = 0;

        // Try to start from each cell in the first column
        for (int i = 0; i < rows; i++) {
            maxMoves = Math.max(maxMoves, dfs(grid, i, 0));
        }

        return maxMoves;
    }

    private int dfs(int[][] grid, int r, int c) {
        // If we reached last column or cell has been computed before, return saved result
        if (c == cols - 1) return 0;
        if (memo[r][c] != null) return memo[r][c];

        int maxMoves = 0;

        // Explore each direction
        for (int[] direction : directions) {
            int newRow = r + direction[0];
            int newCol = c + direction[1];

            // Check if within bounds and valid move (new cell value greater than current cell value)
            if (newRow >= 0 && newRow < rows && newCol < cols && grid[newRow][newCol] > grid[r][c]) {
                maxMoves = Math.max(maxMoves, 1 + dfs(grid, newRow, newCol));
            }
        }

        // Memoize result and return
        memo[r][c] = maxMoves;
        return maxMoves;
    }
}
