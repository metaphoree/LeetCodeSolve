import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal_144 {






    public List<Integer> inorderTraversalCustom(TreeNode root) {
        HashMap<TreeNode,Boolean> visited = new HashMap<>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<Integer> ans = new ArrayList<>();
        // boolean[] visited = new boolean[100000];
        TreeNode elm = root;

        stack.push(root);

        while (!stack.isEmpty()) {
            while (elm.left != null && visited.get(elm.left) == null) {
                stack.push(elm.left);
                elm = elm.left;
            }
            ans.add(elm.val);
            visited.put(elm,true);
            TreeNode rightOfCurrent = elm.right;
            stack.pop();
            if (rightOfCurrent != null) {
                stack.push(rightOfCurrent);
                elm = rightOfCurrent;
                continue;
            }
            if(stack.isEmpty()){
                break;
            }
            elm = stack.peek();
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println(new BST_Inorder_94().inorderTraversal(root));
    }
}
