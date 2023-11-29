package easy;
//方法一：对称二叉树肯定需要两个指针来遍历

public class 对称二叉树 {
    public boolean isSymmetric(TreeNode root) {
        return check(root,root);
    }
    //t1   t2是对称的两个结点
    boolean check(TreeNode t1, TreeNode t2){
        //递归退出的条件
        if(t1==null && t2==null) return true;
        if(t1==null || t2==null) return false;
        //结点值相同，且
        return t1.val==t2.val && check(t1.left,t2.right) && check(t1.right,t2.left);
    }
}
