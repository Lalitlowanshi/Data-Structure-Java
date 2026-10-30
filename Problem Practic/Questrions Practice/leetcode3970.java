
import java.util.*;

class Solution {

    public int shortestPath(int n, int[][] edges, String labels, int k) {

        // Build adjacency list
        List<int[]>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            graph[edge[0]].add(new int[]{edge[1], edge[2]});
        }

        // dist[node][count] = minimum distance
        // count = consecutive identical characters
        long[][] dist = new long[n][k + 1];

        for (long[] row : dist) {
            Arrays.fill(row, Long.MAX_VALUE);
        }

        // PriorityQueue: {distance, node, consecutiveCount}
        PriorityQueue<long[]> pq = new PriorityQueue<>(
            (a, b) -> Long.compare(a[0], b[0])
        );

        // Starting node has consecutive count 1
        dist[0][1] = 0;
        pq.offer(new long[]{0, 0, 1});

        while (!pq.isEmpty()) {

            long[] curr = pq.poll();

            long cost = curr[0];
            int node = (int) curr[1];
            int count = (int) curr[2];

            // Skip outdated states
            if (cost != dist[node][count]) {
                continue;
            }

            // Destination reached
            if (node == n - 1) {
                return (int) cost;
            }

            // Explore neighbours
            for (int[] next : graph[node]) {

                int v = next[0];
                int weight = next[1];

                int nextCount;

                if (labels.charAt(v) == labels.charAt(node)) {
                    nextCount = count + 1;
                } else {
                    nextCount = 1;
                }

                // Invalid consecutive sequence
                if (nextCount > k) {
                    continue;
                }

                long newCost = cost + weight;

                if (newCost < dist[v][nextCount]) {

                    dist[v][nextCount] = newCost;

                    pq.offer(new long[]{
                        newCost, v, nextCount
                    });
                }
            }
        }

        return -1;
    }
}
