package midd;
/*
nums = {1, 2, 3, 4}。
第一个循环 - 计算左侧乘积：

第一次迭代：res[0] = 1，leftProduct = 1 * 1 = 1。
第二次迭代：res[1] = 1，leftProduct = 1 * 2 = 2。
第三次迭代：res[2] = 2，leftProduct = 2 * 3 = 6。
第四次迭代：res[3] = 6，leftProduct = 6 * 4 = 24。
此时，res = {1, 1, 2, 6}，leftProduct = 24。
第二个循环 - 计算右侧乘积并与左侧乘积相乘：

第一次迭代：res[3] *= 1，rightProduct = 1 * 4 = 4。
第二次迭代：res[2] *= 4，rightProduct = 4 * 3 = 12。
第三次迭代：res[1] *= 12，rightProduct = 12 * 2 = 24。
第四次迭代：res[0] *= 24，rightProduct = 24 * 1 = 24。
此时，res = {24, 12, 8, 6}。
 */
public class 除自身以外数组的乘积 {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int[] res=new int[n];
        //res数组存储此元素 左边所有元素的乘积
        int left=1;
        for(int i=0;i<n;i++){
            res[i]=left;
            left*=nums[i];
        }
        //res数组存储此元素 右边所有元素的乘积再与做元素相乘
        int right=1;
        for(int j=n-1;j>=0;j--){
            res[j]*=right; //左积与右积相乘
            right*=nums[j]; //更新右积
        }
        return res;
    }
}
