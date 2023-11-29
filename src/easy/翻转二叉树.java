package easy;
class TreeNode {
     int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

public class 翻转二叉树 {
    public TreeNode invertTree(TreeNode root) {
        if(root==null) return null;
        //交换当前结点的左右子树
        TreeNode tmp=root.right;
        root.right=root.left;
        root.left=tmp;
        //递归左子树和右子树
        invertTree(root.left);
        invertTree(root.right);

        return root;

    }
}
