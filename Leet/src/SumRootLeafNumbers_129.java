import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumRootLeafNumbers_129 {

    List<Integer> ans = new ArrayList<Integer>();

    public int sumNumbers(TreeNode root) {
        if(root == null){
            return 0;
        }
        int sum = 0;
        SumCustom( root,  root.val+"");
        for (int i = 0; i < ans.size(); i++) {
            sum += ans.get(i);
        }
        return sum;
    }

    public void SumCustom(TreeNode root, String value) {

        if (root.left == null && root.right == null) {
            int valueTemp = Integer.valueOf(value);
            ans.add(valueTemp);
        }
        if (root.left != null) {
            SumCustom(root.left, value + root.left.val);
        }
        if (root.right != null) {
            SumCustom(root.right, value + root.right.val);
        }
    }


    public static void main(String[] args) {

        TreeNode root = new TreeNode(70);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);

        //root.left.left = new TreeNode(3);
        //root.left.right = new TreeNode(4);

        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(6);

        System.out.println(new SumRootLeafNumbers_129().sumNumbers(root));

    }
}














