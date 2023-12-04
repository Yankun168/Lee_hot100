package midd;

public class 盛最多水的容器 {
    public int maxArea(int[] height) {
        int i=0;
        int j=height.length-1;
        int res=0;
        while(i<j){
            res=height[i]<height[j]?  //选择更短的板子往里面移动，每次更新res
                    Math.max(res,(j-i)*height[i++]):
                    Math.max(res, (j - i) * height[j--]);
        }
        return res;
    }
}
