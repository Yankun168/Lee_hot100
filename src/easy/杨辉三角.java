package easy;

import java.util.ArrayList;
import java.util.List;

public class 杨辉三角 {
    public List<List<Integer>> generate(int numRows){
        List<List<Integer>> res=new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> cur=new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if(i==j || j==0){
                    cur.add(1);
                }else {
                    cur.add(res.get(i-1).get(j)+res.get(i-1).get(j-1));
                }
            }
            res.add(cur);
        }
        return res;

    }
}
