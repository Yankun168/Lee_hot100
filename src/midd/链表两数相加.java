package midd;

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

public class 链表两数相加 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre=new ListNode(0);  //定义哑节点
        ListNode cur=pre;
        int carry=0;
        while (l1!=null || l2!=null){
            //记录链表中的数值
            int x=l1!=null?l1.val:0;
            int y=l2!=null?l2.val:0;
            int sum=x+y+carry;
            //更新进位位和sum
            carry=sum/10;
            sum=sum%10;
            //插入新节点
            cur.next=new ListNode(sum);
            cur=cur.next;
            if(l1 !=null){
                l1 = l1.next;
            }
            if(l2 !=null){
                l2 = l2.next;
            }
        }
        if(carry==1){
            cur.next=new ListNode(1);
            cur=cur.next;
        }
        return pre.next;

    }
}
