import java.util.*;

class Solution {
    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length;
        int n = classroom[0].length();

        int sr = -1, sc = -1;
        List<int[]> litter = new ArrayList<>();

        // Find starting position and litter cells
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                char ch = classroom[r].charAt(c);

                if (ch == 'S') {
                    sr = r;
                    sc = c;
                } else if (ch == 'L') {
                    litter.add(new int[]{r, c});
                }
            }
        }

        int k = litter.size();

        // No litter
        if (k == 0) {
            return 0;
        }

        // Assign an ID to each litter cell
        int[][] litterId = new int[m][n];

        for (int[] row : litterId) {
            Arrays.fill(row, -1);
        }

        for (int i = 0; i < k; i++) {
            int r = litter.get(i)[0];
            int c = litter.get(i)[1];
            litterId[r][c] = i;
        }

        int targetMask = (1 << k) - 1;

        /*
         * visited[row][col][mask][remainingEnergy]
         */
        boolean[][][][] visited =
            new boolean[m][n][1 << k][energy + 1];

        /*
         * State:
         * [row, col, mask, remainingEnergy]
         */
        Queue<int[]> queue = new ArrayDeque<>();

        visited[sr][sc][0][energy] = true;
        queue.offer(new int[]{sr, sc, 0, energy});

        int moves = 0;

        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};

        while (!queue.isEmpty()) {
            int size = queue.size();

            // All states here require exactly 'moves' moves
            while (size-- > 0) {
                int[] state = queue.poll();

                int r = state[0];
                int c = state[1];
                int mask = state[2];
                int currEnergy = state[3];

                // All litter collected
                if (mask == targetMask) {
                    return moves;
                }

                // Cannot move without energy
                if (currEnergy == 0) {
                    continue;
                }

                for (int d = 0; d < 4; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];

                    // Out of bounds
                    if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                        continue;
                    }

                    // Obstacle
                    if (classroom[nr].charAt(nc) == 'X') {
                        continue;
                    }

                    int newEnergy = currEnergy - 1;
                    int newMask = mask;

                    char cell = classroom[nr].charAt(nc);

                    // Reset energy at R
                    if (cell == 'R') {
                        newEnergy = energy;
                    }

                    // Collect litter
                    if (cell == 'L') {
                        int id = litterId[nr][nc];
                        newMask |= (1 << id);
                    }

                    // Add new state
                    if (!visited[nr][nc][newMask][newEnergy]) {
                        visited[nr][nc][newMask][newEnergy] = true;

                        queue.offer(new int[]{
                            nr,
                            nc,
                            newMask,
                            newEnergy
                        });
                    }
                }
            }

            moves++;
        }

        return -1;
    }
}
