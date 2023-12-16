package midd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 合并区间 {
    public int[][] merge(int[][] intervals) {
        //特殊情况
        if(intervals.length<=1){
            return intervals;
        }
        //一般情况，先将数组首元素排序
        //数组中的每个元素都是一维数组，所以能知道a、b都是数组
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        int[] currentInterval=intervals[0];
        List<int[]> result=new ArrayList<>();
        for(int i=1;i<intervals.length;i++){
            //此cur区间可被延申
            if(currentInterval[1]>=intervals[i][0]){
                currentInterval[1]=Math.max(currentInterval[1],intervals[i][1]);
            }else {
            //此cur区间不可被延申
                result.add(currentInterval);
                currentInterval=intervals[i];
            }
        }
        // 将最后一个区间加入结果列表
        result.add(currentInterval);

        // 将列表转换为数组并返回
        return result.toArray(new int[result.size()][]);
    }
}
