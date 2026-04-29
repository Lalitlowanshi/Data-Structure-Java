class Solution {
    public long maximumScore(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;
        if (m == 1) return 0;

        long[][] col = new long[m][n + 1];

        // prefix sum per column
        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                col[j][i + 1] = col[j][i] + grid[i][j];
            }
        }

        long[][] dp = new long[n + 1][n + 1];
        long[][] prefMax = new long[n + 1][n + 1];
        long[][] suffMax = new long[n + 1][n + 1];

        for (int c = 1; c < m; c++) {

            long[][] newdp = new long[n + 1][n + 1];

            for (int curr = 0; curr <= n; curr++) {
                for (int prev = 0; prev <= n; prev++) {

                    if (curr <= prev) {
                        long gain = col[c][prev] - col[c][curr];

                        newdp[curr][prev] = Math.max(
                                newdp[curr][prev],
                                suffMax[prev][0] + gain
                        );
                    } else {
                        long gain = col[c - 1][curr] - col[c - 1][prev];

                        newdp[curr][prev] = Math.max(
                                newdp[curr][prev],
                                Math.max(
                                        suffMax[prev][curr],
                                        prefMax[prev][curr] + gain
                                )
                        );
                    }
                }
            }

            // build prefix & suffix
            for (int curr = 0; curr <= n; curr++) {

                prefMax[curr][0] = newdp[curr][0];

                for (int prev = 1; prev <= n; prev++) {

                    long penalty = 0;
                    if (prev > curr)
                        penalty = col[c][prev] - col[c][curr];

                    prefMax[curr][prev] = Math.max(
                            prefMax[curr][prev - 1],
                            newdp[curr][prev] - penalty
                    );
                }

                suffMax[curr][n] = newdp[curr][n];

                for (int prev = n - 1; prev >= 0; prev--) {
                    suffMax[curr][prev] = Math.max(
                            suffMax[curr][prev + 1],
                            newdp[curr][prev]
                    );
                }
            }

            dp = newdp;
        }

        long ans = 0;
        for (int k = 0; k <= n; k++) {
            ans = Math.max(ans, Math.max(dp[0][k], dp[n][k]));
        }

        return ans;
    }
}








// Time Limit Exceeded (TLE)..............

// class Solution {
//     public long maximumScore(int[][] grid) {
//         int n = grid.length;

//         long[][] dp = new long[n + 1][n + 1];

//         for (int col = 1; col < n; col++) {
//             long[][] ndp = new long[n + 1][n + 1];

//             for (int prevPrev = 0; prevPrev <= n; prevPrev++) {
//                 for (int prev = 0; prev <= n; prev++) {

//                     for (int cur = 0; cur <= n; cur++) {

//                         long val = dp[prevPrev][prev] +
//                                    score(grid, col - 1, prevPrev, prev, cur);

//                         ndp[prev][cur] = Math.max(ndp[prev][cur], val);
//                     }
//                 }
//             }

//             dp = ndp;
//         }

//         long ans = 0;

//         for (int a = 0; a <= n; a++) {
//             for (int b = 0; b <= n; b++) {
//                 ans = Math.max(ans, dp[a][b] + score(grid, n - 1, a, b, 0));
//             }
//         }

//         return ans;
//     }

//     private long score(int[][] grid, int col, int left, int cur, int right) {
//         int n = grid.length;
//         long res = 0;

//         for (int r = 0; r < n; r++) {

//             boolean black = r < cur;

//             if (!black) { // white cell current column
//                 if ((col > 0 && r < left) || (col + 1 < n && r < right)) {
//                     res += grid[r][col];
//                 }
//             }
//         }

//         return res;
//     }
// }
