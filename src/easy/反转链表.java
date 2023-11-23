package easy;
class ListNode2 {
    int val;
    ListNode2 next;
    ListNode2() {}
    ListNode2(int val) { this.val = val; }
    ListNode2(int val, ListNode2 next) { this.val = val; this.next = next; }
}
public class 反转链表 {
    public ListNode2 reverseList(ListNode2 head) {
        if(head==null) return null;
        if(head.next == null) return head;

        ListNode2 pre=null; //保存前一个结点
        ListNode2 cur=head; //当前访问的结点
        while (cur != null) {
            ListNode2 next = cur.next; //防止后一个结点丢失
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;

    }
}
