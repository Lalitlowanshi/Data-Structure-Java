import java.util.*;

class Solution {

    static class Node {
        int product;
        int[] count;

        Node(int k) {
            product = 1 % k;
            count = new int[k];
        }
    }

    int n;
    int k;
    Node[] tree;

    // Merge two nodes
    private Node merge(Node left, Node right) {

        Node result = new Node(k);

        // Product of entire segment
        result.product = (left.product * right.product) % k;

        // Prefix products completely inside left segment
        for (int i = 0; i < k; i++) {
            result.count[i] += left.count[i];
        }

        // Prefix products which start in right segment
        for (int i = 0; i < k; i++) {
            int newRemainder = (left.product * i) % k;
            result.count[newRemainder] += right.count[i];
        }

        return result;
    }

    // Build segment tree
    private void build(int node, int start, int end, int[] nums) {

        if (start == end) {

            int value = nums[start] % k;

            tree[node] = new Node(k);

            tree[node].product = value;
            tree[node].count[value] = 1;

            return;
        }

        int mid = start + (end - start) / 2;

        build(node * 2, start, mid, nums);
        build(node * 2 + 1, mid + 1, end, nums);

        tree[node] = merge(
            tree[node * 2],
            tree[node * 2 + 1]
        );
    }

    // Update nums[index] = value
    private void update(int node, int start, int end,
                        int index, int value) {

        if (start == end) {

            value %= k;

            tree[node] = new Node(k);

            tree[node].product = value;
            tree[node].count[value] = 1;

            return;
        }

        int mid = start + (end - start) / 2;

        if (index <= mid) {
            update(node * 2, start, mid, index, value);
        } else {
            update(node * 2 + 1, mid + 1, end, index, value);
        }

        tree[node] = merge(
            tree[node * 2],
            tree[node * 2 + 1]
        );
    }

    // Range query [left, right]
    private Node query(int node, int start, int end,
                       int left, int right) {

        // Completely inside range
        if (left <= start && end <= right) {
            return tree[node];
        }

        int mid = start + (end - start) / 2;

        // Entirely in left child
        if (right <= mid) {
            return query(
                node * 2,
                start,
                mid,
                left,
                right
            );
        }

        // Entirely in right child
        if (left > mid) {
            return query(
                node * 2 + 1,
                mid + 1,
                end,
                left,
                right
            );
        }

        // Range crosses both children
        Node leftNode = query(
            node * 2,
            start,
            mid,
            left,
            right
        );

        Node rightNode = query(
            node * 2 + 1,
            mid + 1,
            end,
            left,
            right
        );

        return merge(leftNode, rightNode);
    }

    public int[] resultArray(int[] nums, int k, int[][] queries) {

        this.n = nums.length;
        this.k = k;

        tree = new Node[4 * n];

        // Build tree
        build(1, 0, n - 1, nums);

        int[] answer = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            int index = queries[i][0];
            int value = queries[i][1];
            int start = queries[i][2];
            int x = queries[i][3];

            // 1. Permanently update the array
            update(
                1,
                0,
                n - 1,
                index,
                value
            );

            // 2. Query range [start, n - 1]
            Node result = query(
                1,
                0,
                n - 1,
                start,
                n - 1
            );

            // Number of prefix products having remainder x
            answer[i] = result.count[x];
        }

        return answer;
    }
}
