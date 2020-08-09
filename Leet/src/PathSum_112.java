import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PathSum_112 {


    boolean found = false;
    List<Integer> lst = new ArrayList<Integer>();

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null){
            return false;
        }
        List<Integer> lst = new ArrayList<Integer>();
        lst.add(root.val);
        PathSum(root, lst, sum);
        return found;
    }

    public void PathSum(TreeNode root, List<Integer> list, int sum) {
        if(found){
            return;
        }
        if (root.left == null && root.right == null) {
            if (sum == sumList(list)) {
                found = true;
                return;
            }
        }
        if(root.left != null && !found){
            List<Integer> nList = new ArrayList<Integer>(list);
            nList.add(root.left.val);
            PathSum(root.left,nList,sum);
        }
        if(root.right != null && !found){
            List<Integer> nList2 = new ArrayList<Integer>(list);
            nList2.add(root.right.val);
            PathSum(root.right,nList2,sum);
        }
    }

    public static int sumList(List<Integer> list) {
        int sum = 0;
        for (int i : list) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

      //  root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);
        //root.right.right = new TreeNode(7);

        System.out.println(new PathSum_112().hasPathSum(root,10));

    }
}
