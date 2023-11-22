package easy;

public class 反转链表 {
    public ListNode reverseList(ListNode head) {
        if(head==null) return null;
        if(head.next=null) return head;

        ListNode pre=null; //保存前一个结点
        ListNode cur=head; //当前访问的结点
        while (curr != null) {
            ListNode next = curr.next; //防止后一个结点丢失
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;

    }
}
