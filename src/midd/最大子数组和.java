package midd;
/*
输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
输出：6
解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 */
public class 最大子数组和 {
    public int maxSubArray(int[] nums) {
        int pre=0;
        int maxans=nums[0];
        for(int cur : nums){
            pre=Math.max(pre+cur,cur);
            maxans=Math.max(pre,maxans);
        }
        return maxans;
    }
}
