class Solution {

    int MOD = 1_000_000_007;

    public int[] pathsWithMaxScore(List<String> board) {

        int n = board.size();

        int[][] score = new int[n][n];
        int[][] ways = new int[n][n];

        for (int[] row : score)
            Arrays.fill(row, -1);

        score[0][0] = 0;
        ways[0][0] = 1;

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {

                char ch = board.get(i).charAt(j);

                if (ch == 'X')
                    continue;

                if (i == 0 && j == 0)
                    continue;

                int best = -1;
                long cnt = 0;

                int[][] dir = {
                        {i - 1, j},
                        {i, j - 1},
                        {i - 1, j - 1}
                };

                for (int[] d : dir) {

                    int x = d[0];
                    int y = d[1];

                    if (x < 0 || y < 0)
                        continue;

                    if (score[x][y] == -1)
                        continue;

                    if (score[x][y] > best) {
                        best = score[x][y];
                        cnt = ways[x][y];
                    } else if (score[x][y] == best) {
                        cnt = (cnt + ways[x][y]) % MOD;
                    }
                }

                if (best == -1)
                    continue;

                int val = 0;

                if (ch >= '1' && ch <= '9')
                    val = ch - '0';

                score[i][j] = best + val;
                ways[i][j] = (int) (cnt % MOD);
            }
        }

        if (ways[n - 1][n - 1] == 0)
            return new int[]{0, 0};

        return new int[]{
                score[n - 1][n - 1],
                ways[n - 1][n - 1]
        };
    }
}
