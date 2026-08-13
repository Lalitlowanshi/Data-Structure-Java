class Solution {
    class Node {
        int l, r;
        int lmx, rmx, mx;

        Node(int l, int r) {
            this.l = l;
            this.r = r;
            lmx = rmx = mx = 1;
        }
    }

    class SegmentTree {
        Node[] tree;
        char[] s;

        SegmentTree(char[] s) {
            this.s = s;
            int n = s.length;
            tree = new Node[n * 4];
            build(1, 1, n);
        }

        private void build(int u, int l, int r) {
            tree[u] = new Node(l, r);
            if (l == r) return;

            int mid = (l + r) >> 1;
            build(u << 1, l, mid);
            build(u << 1 | 1, mid + 1, r);
            pushUp(u);
        }

        private void pushUp(int u) {
            Node root = tree[u];
            Node left = tree[u << 1];
            Node right = tree[u << 1 | 1];

            root.lmx = left.lmx;
            root.rmx = right.rmx;
            root.mx = Math.max(left.mx, right.mx);

            int leftLen = left.r - left.l + 1;
            int rightLen = right.r - right.l + 1;

            if (s[left.r - 1] == s[right.l - 1]) {
                if (left.lmx == leftLen)
                    root.lmx += right.lmx;

                if (right.rmx == rightLen)
                    root.rmx += left.rmx;

                root.mx = Math.max(root.mx, left.rmx + right.lmx);
            }
        }

        void modify(int u, int idx, char c) {
            Node node = tree[u];

            if (node.l == node.r) {
                s[idx - 1] = c;
                return;
            }

            int mid = (node.l + node.r) >> 1;

            if (idx <= mid)
                modify(u << 1, idx, c);
            else
                modify(u << 1 | 1, idx, c);

            pushUp(u);
        }

        int query() {
            return tree[1].mx;
        }
    }

    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        SegmentTree st = new SegmentTree(s.toCharArray());

        int m = queryIndices.length;
        int[] ans = new int[m];

        for (int i = 0; i < m; i++) {
            st.modify(1, queryIndices[i] + 1, queryCharacters.charAt(i));
            ans[i] = st.query();
        }

        return ans;
    }
}
