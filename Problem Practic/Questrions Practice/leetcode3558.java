class Solution {
    private static final long MOD = 1_000_000_007L;

    public int assignEdgeWeights(int[][] edges) {
        int n = edges.length + 1;

        java.util.List<Integer>[] graph = new java.util.ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new java.util.ArrayList<>();
        }

        for (int[] e : edges) {
            int u = e[0], v = e[1];
            graph[u].add(v);
            graph[v].add(u);
        }

        int maxDepth = 0;
        java.util.Queue<Integer> queue = new java.util.ArrayDeque<>();
        boolean[] visited = new boolean[n + 1];
        int[] depth = new int[n + 1];

        queue.offer(1);
        visited[1] = true;

        while (!queue.isEmpty()) {
            int u = queue.poll();
            maxDepth = Math.max(maxDepth, depth[u]);

            for (int v : graph[u]) {
                if (!visited[v]) {
                    visited[v] = true;
                    depth[v] = depth[u] + 1;
                    queue.offer(v);
                }
            }
        }

        long ans = modPow(2, maxDepth - 1);
        return (int) ans;
    }

    private long modPow(long base, int exp) {
        if (exp < 0) return 1;

        long res = 1;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                res = (res * base) % MOD;
            }
            base = (base * base) % MOD;
            exp >>= 1;
        }
        return res;
    }
}
