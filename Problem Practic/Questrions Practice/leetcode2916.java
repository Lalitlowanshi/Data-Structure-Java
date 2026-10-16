
class Solution {
    static final long MOD = 1_000_000_007L;

    public int sumCounts(int[] nums) {
        int n = nums.length;
        SegTree st = new SegTree(n);
        int[] last = new int[100001];
        long ans = 0;

        for (int i = 0; i < n; i++) {
            int x = nums[i];

            st.update(1, 0, n - 1, last[x], i, 1);
            last[x] = i + 1;

            ans = (ans + st.query(1, 0, n - 1, 0, i)) % MOD;
        }

        return (int) ans;
    }

    static class SegTree {
        int n;
        long[] sum, sq, lazy;

        SegTree(int n) {
            this.n = n;
            sum = new long[4 * n];
            sq = new long[4 * n];
            lazy = new long[4 * n];
        }

        void apply(int node, int l, int r, long v) {
            long len = r - l + 1L;

            sq[node] = (sq[node]
                    + 2L * v % MOD * sum[node] % MOD
                    + len % MOD * v % MOD * v % MOD) % MOD;

            sum[node] = (sum[node] + len * v) % MOD;
            lazy[node] = (lazy[node] + v) % MOD;
        }

        void push(int node, int l, int r) {
            if (lazy[node] == 0 || l == r) return;

            int mid = (l + r) / 2;
            apply(node * 2, l, mid, lazy[node]);
            apply(node * 2 + 1, mid + 1, r, lazy[node]);
            lazy[node] = 0;
        }

        void update(int node, int l, int r,
                    int ql, int qr, long v) {
            if (ql > r || qr < l) return;

            if (ql <= l && r <= qr) {
                apply(node, l, r, v);
                return;
            }

            push(node, l, r);
            int mid = (l + r) / 2;

            update(node * 2, l, mid, ql, qr, v);
            update(node * 2 + 1, mid + 1, r, ql, qr, v);

            sum[node] = (sum[node * 2] + sum[node * 2 + 1]) % MOD;
            sq[node] = (sq[node * 2] + sq[node * 2 + 1]) % MOD;
        }

        long query(int node, int l, int r,
                   int ql, int qr) {
            if (ql > r || qr < l) return 0;

            if (ql <= l && r <= qr) {
                return sq[node];
            }

            push(node, l, r);
            int mid = (l + r) / 2;

            return (query(node * 2, l, mid, ql, qr)
                    + query(node * 2 + 1, mid + 1, r, ql, qr))
                    % MOD;
        }
    }
}
