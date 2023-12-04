package midd;

import java.util.*;

public class 字母异位词分组 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map=new HashMap<>();
        for(String str : strs){
            char[] chars=str.toCharArray();
            Arrays.sort(chars);//就地排序，无返回值
            String key=new String(chars);  //将字符数组转为String
            List<String> list=map.getOrDefault(key,new ArrayList<>());//遍历到相同类型的key时用原来的list，否则新建list
            list.add(str);
            map.put(key,list);
        }
        //map构建完毕，提取拼接所有value
        return new ArrayList<List<String>>(map.values());
    }
}
