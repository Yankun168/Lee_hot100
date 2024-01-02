package midd;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class 全排列 {
    public List<List<Integer>> permute(int[] nums){
        List<List<Integer>> res=new ArrayList<>();
        Deque<Integer> path=new ArrayDeque<>();//用栈存放中间结果

        int len=nums.length;
        boolean[] used = new boolean[len];
        if(len==0){
            return res;
        }
        //深度deep从0开始，到len结束，作为递归出口
        dfs(res,path,len,0,used,nums);
        return res;
    }

    private void dfs(List<List<Integer>> res, Deque<Integer> path, int len, int depth, boolean[] used, int[] nums) {
        if(depth==len){
            res.add(new ArrayList<>(path));
        }
        for (int i = 0; i < len; i++) {
            if(!used[i]){
                path.addLast(nums[i]);
                used[i]=true;
                dfs(res,path,len,depth+1,used,nums);
                used[i]=false;
                path.removeLast();
            }

        }

    }
}
