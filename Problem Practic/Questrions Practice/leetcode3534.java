class Solution {
    public int[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {

        Integer[] order = new Integer[n];
        for (int i = 0; i < n; i++) order[i] = i;

        Arrays.sort(order, (a, b) -> Integer.compare(nums[a], nums[b]));

        int[] pos = new int[n];
        int[] val = new int[n];

        for (int i = 0; i < n; i++) {
            pos[order[i]] = i;
            val[i] = nums[order[i]];
        }

        // Component ids
        int[] comp = new int[n];
        int cid = 0;
        comp[0] = 0;
        for (int i = 1; i < n; i++) {
            if (val[i] - val[i - 1] > maxDiff) cid++;
            comp[i] = cid;
        }

        // reach[i]
        int[] reach = new int[n];
        int j = 0;
        for (int i = 0; i < n; i++) {
            while (j + 1 < n && val[j + 1] - val[i] <= maxDiff) {
                j++;
            }
            reach[i] = j;
        }

        int LOG = 18;
        int[][] up = new int[LOG][n];
        for (int i = 0; i < n; i++) up[0][i] = reach[i];

        for (int k = 1; k < LOG; k++) {
            for (int i = 0; i < n; i++) {
                up[k][i] = up[k - 1][up[k - 1][i]];
            }
        }

        int m = queries.length;
        int[] ans = new int[m];

        for (int qi = 0; qi < m; qi++) {

            int u = pos[queries[qi][0]];
            int v = pos[queries[qi][1]];

            if (comp[u] != comp[v]) {
                ans[qi] = -1;
                continue;
            }

            if (u == v) {
                ans[qi] = 0;
                continue;
            }

            if (u > v) {
                int t = u;
                u = v;
                v = t;
            }

            int cur = u;
            int steps = 0;

            for (int k = LOG - 1; k >= 0; k--) {
                int nxt = up[k][cur];
                if (nxt < v && nxt != cur) {
                    steps += 1 << k;
                    cur = nxt;
                }
            }

            ans[qi] = steps + 1;
        }

        return ans;
    }
}
