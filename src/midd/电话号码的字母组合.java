package midd;

import java.util.ArrayList;
import java.util.List;

public class 电话号码的字母组合 {
    public List<String> letterCombinations(String digits){
        String[] map={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> res = new ArrayList<>();
        if(digits==null || digits.length()==0) {
            return new ArrayList<>();
        }
        //new StringBuilder()在递归中用letter接收
        iterStr(digits, new StringBuilder(), 0,res,map);
        return res;
    }

    private void iterStr(String digits, StringBuilder sb, int index, List<String> res, String[] map) {
        if(index==digits.length()){
            res.add(sb.toString());
            return;
        }
        //digit为“23” .num依次为’2‘  ’3‘
        char num=digits.charAt(index);
        //对char类型的asii值进行加减
        String map_string=map[num-'0'];
        for (int i = 0; i < map_string.length(); i++) {
            sb.append(map_string.charAt(i));
            iterStr(digits,sb,index+1,res,map);
            sb.deleteCharAt(sb.length()-1);

        }
    }

}
