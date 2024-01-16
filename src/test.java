import java.util.*;

public class test {
    public String decodeString(String s) {
        //存储当前正在解码的部分
        StringBuilder res = new StringBuilder();
        int multi = 0;
        //用于保存 multi 和 res 的中间状态。
        LinkedList<Integer> stack_multi = new LinkedList<>();
        LinkedList<String> stack_res = new LinkedList<>();
        //遍历输入的s
        for (Character c : s.toCharArray()) {
            //遇到左括号
            if (c == '[') {
                //两个元素入栈
                stack_multi.addLast(multi);
                stack_res.addLast(res.toString());
                //分别变为空
                multi = 0;
                res = new StringBuilder();
            }
            //遇到右括号
            else if (c == ']') {
                StringBuilder tmp = new StringBuilder();
                int cur_multi = stack_multi.removeLast();
                for (int i = 0; i < cur_multi; i++) {
                    tmp.append(res);
                }
                res = new StringBuilder(stack_res.removeLast() + tmp);
            }
            //遇到数字
            else if (c >= '0' && c <= '9') {
                //Integer.parseInt的参数为string类型，而c是字符类型
                //c + ""为字符串类型
                multi = multi * 10 + Integer.parseInt(c + "");
            }
            //遇到字符
            else {
                res.append(c);
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        test t = new test();
        System.out.println(t.decodeString("3[a]2[bc]"));
    }
}
