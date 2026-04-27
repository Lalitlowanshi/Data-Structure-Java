class Solution {
    int m, n;
    boolean[][] vis;
    char[][] grid;

    public boolean containsCycle(char[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        vis = new boolean[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(!vis[i][j]) {
                    if(dfs(i, j, -1, -1, grid[i][j])) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean dfs(int r, int c, int pr, int pc, char ch) {
        vis[r][c] = true;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        for(int k = 0; k < 4; k++) {
            int nr = r + dr[k];
            int nc = c + dc[k];

            if(nr < 0 || nc < 0 || nr >= m || nc >= n) continue;
            if(grid[nr][nc] != ch) continue;

            // parent cell ko skip karo
            if(nr == pr && nc == pc) continue;

            // already visited => cycle mil gaya
            if(vis[nr][nc]) return true;

            if(dfs(nr, nc, r, c, ch)) return true;
        }

        return false;
    }
}
