package easy;
/*
动规五部曲：
1.确定dp数组以及下标的含义
dp[i]： 爬到第i层楼梯，有dp[i]种方法，dp[0]在此无意义

2.确定递推公式
从dp[i]的定义可以看出，dp[i] 可以有两个方向推出来。
首先是dp[i - 1]，上i-1层楼梯，有dp[i - 1]种方法，那么再一步跳一个台阶不就是dp[i]了么。
还有就是dp[i - 2]，上i-2层楼梯，有dp[i - 2]种方法，那么再一步跳两个台阶不就是dp[i]了么。
所以dp[i] = dp[i - 1] + dp[i - 2] 。

3.dp数组如何初始化

4.确定遍历顺序
从递推公式dp[i] = dp[i - 1] + dp[i - 2];中可以看出，遍历顺序一定是从前向后遍历的

5.举例推导dp数组
手动画出来
 */

public class 爬楼梯 {
    public int climbStairs(int n) {
        if(n==1) return 1;
        if(n==2) return 2;

        int[] dp=new int[n+1];
        dp[1]=1;
        dp[2]=2;
        for(int i=3;i<n+1;i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];

    }
}
