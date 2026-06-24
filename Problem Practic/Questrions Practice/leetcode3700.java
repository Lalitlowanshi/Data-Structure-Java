class Solution {
    static final long MOD = 1_000_000_007L;

    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1;

        if (n == 1) return m;

        int size = 2 * m;

        // State:
        // 0 ... m-1       -> last move was UP, ending at value i
        // m ... 2m-1      -> last move was DOWN, ending at value i
        long[] vec = new long[size];

        // Length = 2 initialization
        for (int i = 0; i < m; i++) {
            vec[i] = i;               // smaller values before i
            vec[m + i] = m - 1 - i;  // larger values before i
        }

        if (n == 2) {
            long ans = 0;
            for (long x : vec) ans = (ans + x) % MOD;
            return (int) ans;
        }

        long[][] trans = new long[size][size];

        // newUp[x] = sum of down[y], y < x
        for (int x = 0; x < m; x++) {
            for (int y = 0; y < x; y++) {
                trans[x][m + y] = 1;
            }
        }

        // newDown[x] = sum of up[y], y > x
        for (int x = 0; x < m; x++) {
            for (int y = x + 1; y < m; y++) {
                trans[m + x][y] = 1;
            }
        }

        long exp = n - 2;
        long[][] pow = trans;

        while (exp > 0) {
            if ((exp & 1) == 1) {
                vec = multiply(pow, vec);
            }
            pow = multiply(pow, pow);
            exp >>= 1;
        }

        long ans = 0;
        for (long x : vec) {
            ans = (ans + x) % MOD;
        }

        return (int) ans;
    }

    private long[] multiply(long[][] a, long[] v) {
        int n = a.length;
        long[] res = new long[n];

        for (int i = 0; i < n; i++) {
            long sum = 0;
            for (int j = 0; j < n; j++) {
                if (a[i][j] != 0) {
                    sum = (sum + a[i][j] * v[j]) % MOD;
                }
            }
            res[i] = sum;
        }
        return res;
    }

    private long[][] multiply(long[][] a, long[][] b) {
        int n = a.length;
        long[][] res = new long[n][n];

        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n; k++) {
                if (a[i][k] == 0) continue;

                long val = a[i][k];
                for (int j = 0; j < n; j++) {
                    if (b[k][j] == 0) continue;
                    res[i][j] = (res[i][j] + val * b[k][j]) % MOD;
                }
            }
        }
        return res;
    }
}
