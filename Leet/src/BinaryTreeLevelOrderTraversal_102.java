import java.util.*;

public class BinaryTreeLevelOrderTraversal_102 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if (root == null) {
            return list;
        }
        List<Integer> childList = new ArrayList<>();
        Queue<TreeNode> queue1 = new LinkedList<TreeNode>();
        Queue<TreeNode> queue2 = new LinkedList<TreeNode>();
        ((LinkedList<TreeNode>) queue1).push(root);
        childList.add(root.val);
        list.add(childList);
        childList = new ArrayList<>();
        while (!queue1.isEmpty() || !queue2.isEmpty()) {
            while (!queue1.isEmpty()) {
                TreeNode elm = queue1.remove();
                if (elm.left != null) {
                    ((LinkedList<TreeNode>) queue2).add(elm.left);
                    childList.add(elm.left.val);
                } else {
                    // childList.add(-1);
                }
                if (elm.right != null) {
                    ((LinkedList<TreeNode>) queue2).add(elm.right);
                    childList.add(elm.right.val);
                } else {
                    // childList.add(-1);
                }
            }
            if(childList.size() > 0){
                list.add(childList);

            }
            childList = new ArrayList<>();
            queue1 = queue2;
            queue2 = new LinkedList<TreeNode>();
        }
        Collections.reverse(list);
        return list;
    }
    public static void main(String[] args) {

       // System.out.println(new BinaryTreeLevelOrderTraversal_102().);
    }
}
