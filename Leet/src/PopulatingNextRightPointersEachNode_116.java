import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersEachNode_116 {
    public Node connect(Node root) {
        if(root == null){
            return root;
        }
        PopulatingNextRight(root);
        return root;
    }

    public void PopulatingNextRight(Node root) {
        Queue<Node> q1 = new LinkedList<Node>();
        Queue<Node> q2 = new LinkedList<Node>();
        q1.add(root);
        while (!q1.isEmpty()) {
            while (!q1.isEmpty()) {
                Node nd = q1.remove();
                if (nd.left != null) {
                    q2.add(nd.left);
                }
                if (nd.right != null) {
                    q2.add(nd.right);
                }
            }
            if (!q2.isEmpty()) {
                for (int i = 0; i < q2.size() - 1; i++) {
                    ((LinkedList<Node>) q2).get(i).next = ((LinkedList<Node>) q2).get(i+1);
                }
                ((LinkedList<Node>) q2).get(q2.size()-1).next = null;
                q1 = q2;
                q2 = new LinkedList<Node>();
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(2);

        root.left.left = new Node(3);
        root.left.right = new Node(4);

        root.right.left = new Node(4);
        root.right.right = new Node(3);

        System.out.println(new PopulatingNextRightPointersEachNode_116().connect(root));
    }

}
