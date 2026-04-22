import java.util.*;
public class Traversal {
  
    public static List<Integer> preOrderIterative(Node root){
        List<Integer> list = new ArrayList<>();
        Stack<Node> st = new Stack<>();

        if(root == null) return list;
        
        st.push(root);
        while(!st.isEmpty()){
            root = st.pop();
            list.add(root.data);

            if(root.right != null){
                st.push(root.right);
            }
            if(root.left != null){
                st.push(root.left);
            }
        }
        return list;
    }

  public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(4);

        preorder(root);
        System.out.println();
        inorder(root);
        System.out.println();
        postorder(root);
        System.out.println();
        System.out.println(levelOrderTraversal(root));
        System.out.println(preOrderIterative(root));
        System.out.println(inOrderIterative(root));

    }
}

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
    }
}
