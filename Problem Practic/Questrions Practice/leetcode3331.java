
class Solution {
    List<Integer>[] adj;
    List<Integer>[] newAdj;
    int[] last;
    int[] ans;
    String s;

    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;
        this.s = s;

        adj = new ArrayList[n];
        newAdj = new ArrayList[n];
        last = new int[26];
        ans = new int[n];

        Arrays.fill(last, -1);

        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
            newAdj[i] = new ArrayList<>();
        }

        // Build original tree
        for (int i = 1; i < n; i++) {
            adj[parent[i]].add(i);
        }

        // Find new parent for every node
        dfs1(0, -1);

        // Calculate subtree sizes
        dfs2(0);

        return ans;
    }

    void dfs1(int node, int par) {
        int ch = s.charAt(node) - 'a';

        int old = last[ch];

        int newParent = old != -1 ? old : par;

        if (newParent != -1) {
            newAdj[newParent].add(node);
        }

        last[ch] = node;

        for (int child : adj[node]) {
            dfs1(child, node);
        }

        last[ch] = old;
    }

    int dfs2(int node) {
        int size = 1;

        for (int child : newAdj[node]) {
            size += dfs2(child);
        }

        ans[node] = size;

        return size;
    }
}
