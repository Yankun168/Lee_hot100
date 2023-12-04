package midd;

import java.util.HashSet;
import java.util.Set;

public class 连续最长子序列 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        int ans=0;
        for(int num : set){
            int cur=num;
            if(!set.contains(num-1)){
                while (set.contains(cur+1)){
                    cur++;
                }
            }
            ans=Math.max(ans,cur-num+1);
        }
        return ans;

    }
}
