package midd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 找到字符串中所有字母异位词 {
    public List<Integer> findAnagrams(String s, String p) {
        int[] scount=new int[26];
        int[] pcount=new int[26];
        int slen=s.length();
        int plen=p.length();
        List<Integer> res=new ArrayList<>();
        if(slen<plen){
            return new ArrayList<>();
        }
        //为两个数组初始化字符出现频次
        for(int i=0;i<plen;i++){
            ++pcount[p.charAt(i)-'a'];
            ++scount[s.charAt(i)-'a'];
        }
        //pcount初始化结束后就不动了，scount每次移动的时候会改变
        if(Arrays.equals(pcount,scount)){
            res.add(0);
        }
        //开始滑动，窗口大小为plen，窗口起始位置为0到s.len-plen
        for(int i=0;i<slen-plen;i++){
            //每次在字符串s中滑动，然后比较和p数组是否一致
            --scount[s.charAt(i)-'a'];
            ++scount[s.charAt(i+plen)-'a'];
            if(Arrays.equals(pcount,scount)){
                res.add(i+1);
            }
        }
        return res;

    }
}
