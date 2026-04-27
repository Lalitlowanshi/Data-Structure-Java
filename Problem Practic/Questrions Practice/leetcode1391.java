class Solution {

    // directions: up, down, left, right
    int[][] dirs = {
        {-1, 0}, {1, 0}, {0, -1}, {0, 1}
    };

    // street type connections
    int[][][] streets = {
        {},
        {{0, -1}, {0, 1}},     // type 1: left, right
        {{-1, 0}, {1, 0}},     // type 2: up, down
        {{0, -1}, {1, 0}},     // type 3: left, down
        {{0, 1}, {1, 0}},      // type 4: right, down
        {{0, -1}, {-1, 0}},    // type 5: left, up
        {{0, 1}, {-1, 0}}      // type 6: right, up
    };

    public boolean hasValidPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] vis = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{0, 0});
        vis[0][0] = true;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];

            if (x == m - 1 && y == n - 1) return true;

            int type = grid[x][y];

            for (int[] d : streets[type]) {
                int nx = x + d[0];
                int ny = y + d[1];

                if (nx < 0 || ny < 0 || nx >= m || ny >= n || vis[nx][ny])
                    continue;

                // check reverse connection
                if (isConnected(grid[nx][ny], -d[0], -d[1])) {
                    vis[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                }
            }
        }

        return false;
    }

    private boolean isConnected(int type, int dx, int dy) {
        for (int[] d : streets[type]) {
            if (d[0] == dx && d[1] == dy)
                return true;
        }
        return false;
    }
}
