import java.util.*;
public class Traversal {

    public static List<List<Integer>> levelOrderTraversal(Node root){
        List<List<Integer>> list = new LinkedList<List<Integer>>();
        Queue<Node> que = new LinkedList<Node>();
        if(root == null) return list;
        que.add(root);
        while(!que.isEmpty()){
            int levelNum = que.size();
            List<Integer> sublist = new LinkedList<Integer>();
            for(int i=0; i<levelNum; i++){
                if(que.peek().left != null) que.add(que.peek().left);
                if(que.peek().right != null) que.add(que.peek().right);
                sublist.add(que.poll().data);
            }
            list.add(sublist);
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
    }
}

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
    }
}
