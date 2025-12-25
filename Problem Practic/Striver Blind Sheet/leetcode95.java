// class Solution {
//     public List<Integer> inorderTraversal(TreeNode root) {
//         List<Integer> result = new ArrayList<>();
//         inorder(root, result);
//         return result;
//     }

//     private void inorder(TreeNode node, List<Integer> result) {
//         if (node == null) return;

//         inorder(node.left, result);
//         result.add(node.val);
//         inorder(node.right, result);
//     }
// }



class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {

            // go to the leftmost node
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            // process node
            current = stack.pop();
            result.add(current.val);

            // move to right subtree
            current = current.right;
        }

        return result;
    }
}
