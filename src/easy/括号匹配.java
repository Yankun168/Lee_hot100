package easy;

import java.util.*;

public class 括号匹配 {
    public boolean isValid(String s) {
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }

        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        //遍历s中的每一个括号
        //如果栈空或者栈顶元素不等于当前遍历到的元素，返回错误
        //其他情况说明括号对应上了，栈顶元素出栈
        Deque<Character> stack=new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char ch=s.charAt(i);
            if(pairs.containsKey(ch)){//右括号，查看匹配情况
                if(stack.isEmpty() || stack.peek() != pairs.get(ch)){
                    return false;
                }
                stack.pop();
            } else{   //左括号，入栈
                stack.push(ch);
            }


        }
        //遍历结束若栈中无元素了，则匹配成功
        return stack.isEmpty();

    }
}
