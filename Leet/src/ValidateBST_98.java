import java.util.ArrayList;
import java.util.List;

public class ValidateBST_98 {


    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        long flag = Integer.MAX_VALUE + 3;
        long[] result = validateBSTCustom(root, false, true);
        if (result[0] == flag || result[1] == flag) {
            return false;
        }
        return true;
    }

    public long[] validateBSTCustom(TreeNode root, boolean isLeft, boolean isRoot) {
        long flag = Integer.MAX_VALUE + 3;
        long[] leftRes = new long[2];
        long[] rightRes = new long[2];
        if (root.left != null) {
            leftRes = validateBSTCustom(root.left, true, false);
        }
        if (root.right != null) {
            rightRes = validateBSTCustom(root.right, false, false);
        }

        if (root.left == null && root.right == null) {
            if (isRoot) {
                return new long[]{flag+1, root.val};
            } else if (isLeft) {
                return new long[]{flag, root.val};
            } else {
                return new long[]{root.val, flag};
            }

        } else if (root.left != null && root.right != null) {
            // conforms
            if ((leftRes[1] != -1 && rightRes[0] != -1)
                    && (root.val > leftRes[1] && root.val < rightRes[0])) {
                if (leftRes[0] == flag || rightRes[1] == flag) {
                    if (leftRes[0] ==flag && rightRes[1] == flag) {
                        return new long[]{leftRes[1], rightRes[0]};
                    } else if (leftRes[0] == flag) {
                        return new long[]{leftRes[1], rightRes[1]};
                    } else if (rightRes[1] == flag) {
                        return new long[]{leftRes[0], rightRes[0]};
                    }
                } else {
                    return new long[]{leftRes[0], rightRes[1]};
                }
            }
            // not conforms
            else {
                if (isRoot) {
                    return new long[]{flag, flag};
                } else if (isLeft) {
                    return new long[]{flag, flag};
                } else {
                    return new long[]{flag, flag};
                }
            }
        } else if (root.right != null) {
            // conforms
            if (root.val < rightRes[0] && rightRes[0] != flag) {
                if (rightRes[1] == flag) {
                    return new long[]{root.val, rightRes[0]};
                } else {
                    return new long[]{root.val, rightRes[1]};
                }
            }
            // not conforms
            else {
                if (isRoot) {
                    return new long[]{flag,flag};
                } else {
                    return new long[]{flag,flag};
                }
            }
        } else if (root.left != null) {
            // conforms
            if (root.val > leftRes[1] && leftRes[1] != flag) {
                if (leftRes[0] == flag) {
                    return new long[]{leftRes[1], root.val};
                } else {
                    return new long[]{leftRes[0], root.val};
                }
            }
            // not conforms
            else {
                if (isRoot) {
                    return new long[]{flag,flag};
                } else {
                    return new long[]{flag,flag};
                }
            }
        }
            return new long[]{flag,flag};
    }


    public static void main(String[] args) {

        TreeNode root = new TreeNode(70);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);

        //root.left.left = new TreeNode(3);
        //root.left.right = new TreeNode(4);

        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(6);

        System.out.println(new ValidateBST_98().isValidBST(root));

    }
}
