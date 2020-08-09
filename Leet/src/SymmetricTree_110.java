import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SymmetricTree_110 {


    // Definition for a binary tree node.

    public boolean isSymmetric(TreeNode root) {
        return findSymmetricity(root);
    }
  /*
  [100,2,300,null,10,299,400,9,11,null,null,101,405,8,13,null,null,17,null,404,null,null,null,null,null,null,800]

  [100,2,10,9,8,13,11,300,299,400,101,17,800,405,404]
[2,8,9,13,10,11,100,299,300,17,800,101,400,404,405]
-------------------------------------------------------------------
[37,-34,-48,null,-100,-100,48,null,null,null,null,-54,null,-71,-22,null,null,null,8]

[37,-34,-100,-48,-100,48,-54,-71,-22,8]
[-34,-100,37,-100,-48,-71,-54,-22,8,48]

-------------------------------------------------------------------
[70,null,45,null,34,null,26,null,26,null,9]

[70,45,34,26,9]
[70,45,34,26,9]
-------------------------------------------------------------------


[100,50,49,45,51,58,102,101,109,107,120]
[45,49,50,51,58,100,101,102,107,109,120]


[100,50,102,49,51,101,109,45,null,null,58,null,null,107,120]

----------------------------
[100,50,60,59]
[50,59,60,100]

[100,50,null,null,60,59,null]
---------------------------------
[100,null,50,null,60,59,null,70,46,56]

[100,50,60,59,70,56,46]
[100,50,56,70,59,46,60]

----------------------------------


   */


/*
[37,-34,-48,null,-100,-100,48,null,null,null,null,-54,null,-71,-22,null,null,null,8]
[1,2,null,4,null,6,null,7,null,9]
[3,4,4,5,null,null,5,6,null,null,6,8,7,7,8]
[100,2,300,null,10,299,400,9,11,null,null,101,405,8,13,null,null,17,null,404,null,null,null,null,null,null,800]
[70,45,null,34,null,26,null,17,null,9]
[70,null,45,null,34,null,26,null,26,null,9]
[70,null,45,null,34,null,26,10,17,null,9]
[100,4,5]
[100]
[]
[100,50,102,49,51,101,109,45,50]
[100,50,102,49,51,101,109,45]
[100,50,102,49,51,101,109,45,null,null,58,null,null,107,120]
[100,50,107,49,51,101,109,45,null,null,58,null,105]
[100,50,107,49,51,103,109,45,null,null,58,101,105]
[100,50,107,49,null,103,109,45,null,null,101,105]
[100,50,107,49,null,103,109,45,null,null,105,105]
[100,50,null,null,60,59,null]
[100,null,50,null,60,59,null]
[100,null,50,null,60,59,null,70,46,56]
[150,100,200,90,110,225,300]
[150,100,200,90,110,175,300]
[150,100,200,90,null,175,300]
[150,100,200,null,null,175,300]
[150,100,200,90,null,null,300]
[150,100,200,90,null,null]
[150,100,200,null,110,175,null]
[3,null,30,10,null,null,15,null,45]
[0,-1]
  */





    public boolean findSymmetricity(TreeNode root) {
        if (root == null) {
            return true;
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        Queue<TreeNode> queue1 = new LinkedList<TreeNode>();
        Queue<TreeNode> queue2 = new LinkedList<TreeNode>();
        ((LinkedList<TreeNode>) queue1).push(root);

        while (!queue1.isEmpty() || !queue2.isEmpty()) {
            while (!queue1.isEmpty()) {
                TreeNode elm = queue1.remove();
                if (elm.left != null) {
                    ((LinkedList<TreeNode>) queue2).add(elm.left);
                    list.add(elm.left.val);
                } else {
                    list.add(-1);
                }
                if (elm.right != null) {
                    ((LinkedList<TreeNode>) queue2).add(elm.right);
                    list.add(elm.right.val);
                } else {
                    list.add(-1);
                }
            }
            if (!checkPalindrom(list)) {
                return false;
            }
            list.clear();
            queue1 = queue2;
            queue2 = new LinkedList<TreeNode>();
        }

        return true;
    }

    public boolean checkPalindrom(List<Integer> list) {
        int start = 0, end = list.size() - 1;
        while (start < end) {
            if (list.get(start) != list.get(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        System.out.println(new SymmetricTree_110().isSymmetric(root));
    }


}
