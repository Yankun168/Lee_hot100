package midd;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class 二叉树层次遍历 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }
        //广度优先遍历
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<TreeNode> queue=new LinkedList<>();  //linkedlist可以作为队列使用实现了Queue
        queue.add(root);
        while (queue.size()>0){
            int size=queue.size();
            List<Integer> tem=new ArrayList<>(); //每一层都放在tem中
            for (int i = 0; i < size; i++) {
                TreeNode t=queue.remove(); //删除并返回第一个元素。
                tem.add(t.val);
                if(t.left!=null){
                    queue.add(t.left);
                }
                if(t.right!=null){
                    queue.add(t.right);
                }
            }
            //将tem单列表放入双列表res中
            res.add(tem);
        }
        return res;


    }
}
