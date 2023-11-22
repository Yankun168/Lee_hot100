package easy;
/*
方法一：创建两个指针 i 和 count_idx（作为非零元素的个数，以及下一个非零元素的下标），若遍历到的元素不是0，count++,
       第一次遍历完后，j 指针的下标就指向了最后一个 非0 元素下标。
 */
public class 移动零 {
    public void moveZeroes(int[] nums) {
        int count_Idx=0;
        //j记录有多少非零元素，同时j移动至所有非零元素的后一个位置
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]!=0){      //当前元素不为0，
                nums[count_Idx]=nums[i];
                count_Idx++;
            }
        }

        //不为0的数字已全部移动至前方，接下来补充0
        for (int j = count_Idx; j < nums.length; j++) {
            nums[j]=0;
        }

    }
}
