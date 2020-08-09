import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversal_145 {

    List<Integer> ans = new ArrayList<>();

    public List<Integer> postorderTraversal(TreeNode root) {
        bTreePostOrderIterative(root);
        return ans;
    }

    public void bTreePostOrderIterative(TreeNode root) {
        HashMap<TreeNode, Integer> hash = new HashMap<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        hash.put(root, 0);
        TreeNode elm = root;
        while (!stack.isEmpty()) {

            while (elm.left != null && hash.get(elm) < 1) {
                stack.push(elm.left);
                hash.put(elm, 1);
                hash.put(elm.left, 0);
                elm = elm.left;
            }
            if (elm.right != null && hash.get(elm) < 2) {
                hash.put(elm, 2);
                stack.push(elm.right);
                hash.put(elm.right, 0);
                elm = elm.right;
                continue;
            }
            ans.add(elm.val);
            stack.pop();
            TreeNode temp = stack.pop();
            while (hash.get(temp) == 2 && !stack.isEmpty()) {
                temp = stack.pop();
                ans.add(temp.val);
            }
            if (stack.isEmpty() && temp.right == null) {
                break;
            }
            hash.put(temp, 2);
            elm = temp.right;
            stack.push(elm);
            hash.put(elm, 0);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        System.out.println(new BinaryTreePostorderTraversal_145().postorderTraversal(root));
    }
/*
              1

      2               2

  3       4      4         3



 */


}


//    public static void main(String[] args) {
//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(3);
//
//        root.left.left = new TreeNode(4);
//        root.left.right = new TreeNode(5);
//
//        root.right.left = new TreeNode(6);
//        root.right.right = new TreeNode(7);
//
//        System.out.println(new BST_Inorder_94().inorderTraversal(root));
//    }