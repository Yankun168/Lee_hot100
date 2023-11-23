package easy;
/*
方法一：将列表转为数组【】，然后判断数组是否是回文
方法二：快慢指针，边走边反转前半部分链表【不会】
 */
import java.util.ArrayList;
import java.util.List;

class ListNode1 {
    int val;
    ListNode1 next;
    ListNode1() {}
    ListNode1(int val) { this.val = val; }
    ListNode1(int val, ListNode1 next) { this.val = val; this.next = next; }
}
public class 回文链表 {
    public boolean isPalindrome(ListNode head) {
        List<ListNode> list=new ArrayList<>();
        while(head!=null){
            list.add(head);
            head=head.next;
        }
        //List转数字
        int size=list.size();
        int[] tem=new int[size];
        for (int i = 0; i < size; i++) {
            tem[i]=list.get(i).val;
        }
        if(isP(tem)) return true;
        return false;
    }
    public boolean isP(int[] nums){
        int i=0;
        int j=nums.length-1;
        while(i<=j){
            if(nums[i]==nums[j]){
                i++;
                j--;
            }else{
                return false;
            }
        }
        return true;
    }

}
