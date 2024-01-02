package midd;

import java.util.HashMap;
import java.util.Map;

public class 路径总和之二叉树 {
    int ans=0;
    public int pathSum(TreeNode root, int targetSum){
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        dfs(root,map,0,targetSum);
        return ans;
    }

    private void dfs(TreeNode root, Map<Integer, Integer> map, int cursum, int targetSum) {
        if (root==null){
            return;
        }
        //获取前缀和
        cursum+=root.val;
        //更新最后结果
        ans+=map.getOrDefault(cursum-targetSum,0);
        map.put(cursum,map.getOrDefault(cursum,0)+1);
        //递归左右子树
        dfs(root.left,map,cursum,targetSum);
        dfs(root.right,map,cursum,targetSum);
        //回溯
        map.put(cursum,map.getOrDefault(cursum,0)-1);
    }
}
