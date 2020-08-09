import java.util.ArrayList;
import java.util.List;

public class Path_Sum_II_113 {

    List<List<Integer>> ans2 = new ArrayList<List<Integer>>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root == null){
           return ans2;
        }
        List<Integer> op = new ArrayList<>();op.add(root.val);
        Path_Sum(root,op,sum,root.val);
        return ans2;
    }

    public void Path_Sum(TreeNode root, List<Integer> list, int sum,int currentSum) {

        if (root.left == null && root.right == null) {
            if (sum == currentSum) {
                ans2.add(list);
                return;
            }
        }
        if (root.left != null) {
            List<Integer> nList = new ArrayList<Integer>(list);
            nList.add(root.left.val);
            Path_Sum(root.left, nList, sum,currentSum + root.left.val);
        }
        if (root.right != null) {
            List<Integer> nList2 = new ArrayList<Integer>(list);
            nList2.add(root.right.val);
            Path_Sum(root.right, nList2, sum,currentSum + root.right.val);
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

        System.out.println(new Path_Sum_II_113().pathSum(root,7));

    }
}
