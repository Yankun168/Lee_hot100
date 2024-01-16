package midd;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class 分割回文串 {
    List<List<String>> res = new ArrayList<>();
    Deque<String> path = new ArrayDeque<>();
    public List<List<String>> partition(String s){
        dfs(s,0);
        return res;
    }
    //确定递归参数
    private void dfs(String s, int startIndex) {
        //递归终止条件
        if(startIndex==s.length()){
            res.add(new ArrayList<>(path));
            return;
        }
        //单层回溯逻辑  重点
        //[startIndex, i] 就是要截取的子串。startIdx初始为0
        //其实就是index是上一层已经确定了的分割线，i是这一层试图寻找的新分割线
        for (int i = startIndex; i < s.length() ; i++) {
            if(isHW(s,startIndex,i)){
                String str=s.substring(startIndex,i+1);
                path.addLast(str);
            }else {
                continue;
            }
            //单层逻辑写完开始回溯
            dfs(s,i+1);
            path.removeLast();

        }

    }

    private boolean isHW(String s, int startIndex, int i) {
        if(s.length()==1) return true;
        for (int begin=startIndex, end=i; begin <=end ; begin++,end--) {
            if (s.charAt(begin) != s.charAt(end)) {
                return false;
            }
        }
        return true;
    }
}
