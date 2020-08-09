import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal_105 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 || inorder.length == 0){
            return null;
        }

        TreeNode root = new TreeNode(-1);
        List<Integer> preord = new ArrayList<Integer>();
        List<Integer> inord = new ArrayList<Integer>();
        for (int t : preorder) {
            // Add each element into the list
            preord.add(t);
        }
        for (int t : inorder) {
            // Add each element into the list
            inord.add(t);
        }
        constBTree(preord, inord, root);
        return root;
    }

    public void constBTree(List<Integer> preorder, List<Integer> inorder, TreeNode root) {
        if (preorder.size() == 1 && inorder.size() == 1) {
            root.val = preorder.get(0);
            return;
        }
        root.val = preorder.get(0);
        int index = getRootIndex(inorder, preorder.get(0));
        if (index != 0) {
            root.left = new TreeNode(-1);
            constBTree(preorder.subList(1, index + 1), inorder.subList(0, index), root.left);
        }
        if (index != preorder.size() - 1) {
            root.right = new TreeNode(-1);
            constBTree(preorder.subList(index + 1, preorder.size()), inorder.subList(index + 1, preorder.size()), root.right);
        }
    }

    int getRootIndex(List<Integer> list, int value) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == value) {
                return i;
            }
        }
        return -1;
    }


    public static void main(String[] args) {

        System.out.println
                (new ConstructBinaryTreeFromPreorderAndInorderTraversal_105()
                        .buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7}).val);
    }
}
