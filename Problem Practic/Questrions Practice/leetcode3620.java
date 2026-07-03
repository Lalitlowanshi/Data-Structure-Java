import java.util.*;

class Solution {
    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        int n = online.length;

        List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        int[] indegree = new int[n];
        List<Integer> costs = new ArrayList<>();

        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            int w = e[2];

            graph[u].add(new int[]{v, w});
            indegree[v]++;
            costs.add(w);
        }

        // Topological Sort
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int[] topo = new int[n];
        int idx = 0;

        while (!queue.isEmpty()) {
            int u = queue.poll();
            topo[idx++] = u;

            for (int[] edge : graph[u]) {
                int v = edge[0];
                if (--indegree[v] == 0) {
                    queue.offer(v);
                }
            }
        }

        Collections.sort(costs);

        // Remove duplicate edge costs
        List<Integer> values = new ArrayList<>();
        for (int c : costs) {
            if (values.isEmpty() || values.get(values.size() - 1) != c) {
                values.add(c);
            }
        }

        int left = 0;
        int right = values.size() - 1;
        int ans = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int limit = values.get(mid);

            if (check(limit, graph, topo, online, k, n)) {
                ans = limit;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }

    private boolean check(int limit, List<int[]>[] graph, int[] topo,
                          boolean[] online, long k, int n) {

        long INF = Long.MAX_VALUE / 4;
        long[] dist = new long[n];
        Arrays.fill(dist, INF);
        dist[0] = 0;

        for (int u : topo) {
            if (dist[u] == INF) continue;

            if (u != 0 && u != n - 1 && !online[u]) continue;

            for (int[] edge : graph[u]) {
                int v = edge[0];
                int w = edge[1];

                if (w < limit) continue;
                if (v != n - 1 && !online[v]) continue;

                if (dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                }
            }
        }

        return dist[n - 1] <= k;
    }
}
