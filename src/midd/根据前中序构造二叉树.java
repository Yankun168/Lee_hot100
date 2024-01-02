package midd;

import java.util.HashMap;
import java.util.Map;

public class 根据前中序构造二叉树 {
    public TreeNode buildTree(int[] preorder, int[] inorder){
        Map<Integer,Integer> map=new HashMap<>();
        int n=inorder.length;
        //构建中序值K和索引V的映射
        for (int i = 0; i < n; i++) {
            map.put(inorder[i],i);
        }
        return buildMyTree(map,preorder,0,n-1,0,n-1);
    }

    private TreeNode buildMyTree(Map<Integer,Integer> map,int[] preorder,int preorder_left,int preorder_right,int inorder_left,int inorder_right) {
        //递归出口
        if(preorder_left>preorder_right || inorder_left>inorder_right){
            return null;
        }
        int root_val=preorder[preorder_left];
        TreeNode root=new TreeNode(root_val);
        int pIndex=map.get(root_val);
        root.left=buildMyTree(map,preorder,preorder_left+1,pIndex-inorder_left+preorder_left,inorder_left,pIndex);
        root.right=buildMyTree(map,preorder,pIndex-inorder_left+preorder_left+1,preorder_right,pIndex+1,inorder_right);
        return root;
    }
}
