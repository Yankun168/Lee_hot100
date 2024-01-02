package easy;
class TreeNode {
    int val;
    TreeNodedD left;
    TreeNodedD right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNodedD left, TreeNodedD right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class 二叉树的最大深度 {
    class Solution {
        public int maxDepth(TreeNodedD root) {
            if(root==null){
                return 0;
            }
            if(root.left==null && root.right==null){
                return 1;
            }
            int m=maxDepth(root.left);
            int n=maxDepth(root.right);
            int res=m>n?m:n;
            return res+1;

        }
    }
}
