package easy;

import java.util.HashMap;
import java.util.Map;
//方法一，两层for暴力搜索
//int[] a=new int[]{1,2,3};  java初始化数组的方法
//int[] a={1,2,3};           省略的格式

/*
方法二  想到hashmap找元素很快的特点
将元素和其下标分别用key和value表示
核心是寻找target-num[i]
 */

public class 两数之和 {
    public int[] twoSum(int[] nums, int target){
        //这里key是元素num[i]，value是下标
        Map<Integer, Integer> ht=new HashMap<>();
        //遍历nums数组，访问过的就放入hashmap中，接着在hashmap中寻找target-num[i]。
        for (int i = 0; i < nums.length; i++) {
            if(ht.containsKey(target-nums[i])){
                return new int[]{i,ht.get(target-nums[i])};
            }
            ht.put(nums[i],i );
        }
        return null;

    }
}
