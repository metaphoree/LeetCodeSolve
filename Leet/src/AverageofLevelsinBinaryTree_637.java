import java.util.*;

public class AverageofLevelsinBinaryTree_637 {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> list = new ArrayList<Double>();
        if (root == null) {
            return list;
        }
         List<Integer> childList = new ArrayList<>();
        Queue<TreeNode> queue1 = new LinkedList<TreeNode>();
        Queue<TreeNode> queue2 = new LinkedList<TreeNode>();
        ((LinkedList<TreeNode>) queue1).push(root);

        list.add(Double.valueOf(root.val));

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
                // list.add(childList);
                Long sum = Long.valueOf(0);

                for (int i : childList)
                    sum = sum + i;

                 list.add(Double.valueOf(sum / Double.valueOf(childList.size())));
            }
            childList = new ArrayList<>();
            queue1 = queue2;
            queue2 = new LinkedList<TreeNode>();
        }
        return list;
    }
    public static void main(String[] args) {

        // System.out.println(new BinaryTreeLevelOrderTraversal_102().);
    }
}
