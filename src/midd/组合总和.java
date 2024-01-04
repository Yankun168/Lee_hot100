package midd;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class 组合总和 {
    //全局变量，减少回溯参数
    Deque<Integer> path = new ArrayDeque<>();
    List<List<Integer>> res=new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target){
        //0表示从数组中的第一个数字开始遍历
        dfs(candidates,target,0);
        return res;

    }

    private void dfs(int[] candidates, int target , int begin) {
        //树中每个结点的值都作为target
        if(target<0){
            return;
        }
        if(target==0){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i < candidates.length; i++) {
            path.addLast(candidates[i]);
            dfs(candidates,target-candidates[i],i);
            path.removeLast();
        }
    }
}
