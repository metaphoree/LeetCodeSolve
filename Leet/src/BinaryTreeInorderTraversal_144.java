import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal_144 {

    List<Integer> ans = new ArrayList<Integer>();

    public List<Integer> preorderTraversal(TreeNode root) {

        if (root == null) {
            return new ArrayList<>();
        }
        preorderTraverseIterative(root);
        return ans;
    }

    public void preorderTraverseIterative(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        TreeNode elm = root;
        ans.add(root.val);
        while (!stack.isEmpty()) {
            while (elm.left != null) {
                stack.push(elm.left);
                ans.add(elm.left.val);
                elm = elm.left;
            }
            TreeNode right = elm.right;
            stack.pop();
            if (right != null) {
                stack.push(right);
                ans.add(right.val);
                elm = right;
                continue;
            }

            while (elm.right == null && !stack.isEmpty()) {
                elm = stack.pop();
            }
            if(stack.isEmpty() && elm.right == null){
                break;
            }
            elm = elm.right;
            ans.add(elm.val);
            stack.push(elm);

        }
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println(new BinaryTreeInorderTraversal_144().preorderTraversal(root));
    }
}
