package easy;
class TreeNodedD {
    int val;
    TreeNodedD left;
    TreeNodedD right;
    TreeNodedD() {}
    TreeNodedD(int val) { this.val = val; }
    TreeNodedD(int val, TreeNodedD left, TreeNodedD right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class 二叉树的直径 {
    class Solution {
        int ans=0;   //全局答案
        public int diameterOfBinaryTree(TreeNodedD root) {

            depth(root);
            return ans;
        }
        public int depth(TreeNodedD node){
            if(node==null){
                return 0;
            }
            int L=depth(node.left);
            int R=depth(node.right);
            ans=Math.max(L+R,ans);
            return Math.max(L,R)+1 ;
        }
    }
}
