import java.util.*;

public class Solution {
    public int[][] validArrangement(int[][] pairs) {
        // Adjacency list to represent the graph
        Map<Integer, Stack<Integer>> graph = new HashMap<>();
        // Maps to store in-degree and out-degree
        Map<Integer, Integer> inDegree = new HashMap<>();
        Map<Integer, Integer> outDegree = new HashMap<>();
        
        // Build the graph and degree maps
        for (int[] pair : pairs) {
            int u = pair[0], v = pair[1];
            graph.putIfAbsent(u, new Stack<>());
            graph.get(u).push(v);
            
            outDegree.put(u, outDegree.getOrDefault(u, 0) + 1);
            inDegree.put(v, inDegree.getOrDefault(v, 0) + 1);
        }

        // Find the starting node
        int start = pairs[0][0]; // Default start (if Eulerian circuit exists)
        for (int key : graph.keySet()) {
            int out = outDegree.getOrDefault(key, 0);
            int in = inDegree.getOrDefault(key, 0);
            if (out - in == 1) {
                start = key; // Start of Eulerian path
                break;
            }
        }

        // Perform Hierholzer's algorithm
        LinkedList<Integer> path = new LinkedList<>();
        dfs(start, graph, path);

        // Convert the path to the result array
        int[][] result = new int[pairs.length][2];
        int idx = 0;
        Iterator<Integer> it = path.iterator();
        int prev = it.next();
        while (it.hasNext()) {
            int next = it.next();
            result[idx++] = new int[]{prev, next};
            prev = next;
        }

        return result;
    }

    private void dfs(int node, Map<Integer, Stack<Integer>> graph, LinkedList<Integer> path) {
        Stack<Integer> stack = graph.getOrDefault(node, new Stack<>());
        while (!stack.isEmpty()) {
            int next = stack.pop();
            dfs(next, graph, path);
        }
        path.addFirst(node); // Add node to the path in reverse order
    }
}
