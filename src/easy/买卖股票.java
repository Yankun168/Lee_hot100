package easy;
/*
贪心算法思想：
在每一步选择中都采取当前状态下最优的选择，从而希望导致全局最优解的算法设计策略。

通过一次遍历，我们可以确定一个最低买入点，同时也能找到以当前价格卖出时的最大利润。在遍历过程中不断更新这些值，最终得到全局最优解。

 */
public class 买卖股票 {
    public int maxProfit(int prices[]) {
        // 初始化最小价格为整数的最大值，初始化最大利润为0
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;

        // 遍历股票价格数组
        for (int i = 0; i < prices.length; i++) {
            // 如果当前价格比最小价格小，更新最小价格
            if (prices[i] < minprice) {
                minprice = prices[i];
            }
            // 如果当前价格减去最小价格大于最大利润，更新最大利润
            else if (prices[i] - minprice > maxprofit) {
                maxprofit = prices[i] - minprice;
            }
        }

        // 返回最大利润
        return maxprofit;
    }
}
