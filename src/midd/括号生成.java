package midd;

import java.util.ArrayList;
import java.util.List;

public class 括号生成 {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<String>();
        //StringBuilder()方便对字符串进行修改。当栈用
        //左括号0个，右括号0个，总共n对括号
        backtrack(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }

    public void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max) {
        if (cur.length() == max * 2) {
            //注意别忘记toString
            ans.add(cur.toString());
            return;
        }
        //左括号：能加就一直加
        if (open < max) {
            cur.append('(');
            backtrack(ans, cur, open + 1, close, max);
            cur.deleteCharAt(cur.length() - 1);
        }
        //右括号：数量比左括号少的时候加
        if (close < open) {
            cur.append(')');
            backtrack(ans, cur, open, close + 1, max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}
