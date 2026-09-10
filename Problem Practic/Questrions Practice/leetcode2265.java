/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {

    private int ans = 0;

    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return ans;
    }

    // Returns {sum of subtree, number of nodes in subtree}
    private int[] dfs(TreeNode root) {

        // Empty subtree
        if (root == null) {
            return new int[]{0, 0};
        }

        // Get information from left and right subtrees
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        // Calculate information for current subtree
        int sum = left[0] + right[0] + root.val;
        int count = left[1] + right[1] + 1;

        // Check if current node equals subtree average
        if (sum / count == root.val) {
            ans++;
        }

        // Return sum and count to parent
        return new int[]{sum, count};
    }
}
