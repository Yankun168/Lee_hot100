package easy;
class treeNode {
     int val;
      TreeNodedD left;
      TreeNodedD right;
      treeNode() {}
      treeNode(int val) { this.val = val; }
      treeNode(int val, TreeNodedD left, TreeNodedD right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

public class 翻转二叉树 {
    public TreeNodedD invertTree(TreeNodedD root) {
        if(root==null) return null;
        //交换当前结点的左右子树
        TreeNodedD tmp=root.right;
        root.right=root.left;
        root.left=tmp;
        //递归左子树和右子树
        invertTree(root.left);
        invertTree(root.right);

        return root;

    }
}
