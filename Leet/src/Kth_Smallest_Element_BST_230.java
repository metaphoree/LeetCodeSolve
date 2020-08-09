public class Kth_Smallest_Element_BST_230 {
    int count = 0;
    int value = 0;
    boolean found = false;
    public int kthSmallest(TreeNode root, int k) {
        if(root == null){
            return 0;
        }
        KTH_Smallest_Element(root,k);
        return value;
    }
    public void KTH_Smallest_Element(TreeNode root, int k){
        if(found == true){
            return;
        }
        if(root.left != null){
            kthSmallest(root.left,k);
        }
        count++;
        if(count == k){
            value = root.val;
            found = true;
        }
        if(root.right != null && found == false) {
            kthSmallest(root.right, k);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(100);
     //   root.left = new TreeNode(50);
    //    root.right = new TreeNode(200);

  //      root.left.left = new TreeNode(30);
       // root.left.right = new TreeNode(60);

       // root.right.left = new TreeNode(150);
//        root.right.right = new TreeNode(250);

        System.out.println(new Kth_Smallest_Element_BST_230().kthSmallest(root,2));

    }
}
