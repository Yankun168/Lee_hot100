package easy;

class ListNode3 {
    int val;
    ListNode3 next;
    ListNode3(int x) {
        val = x;
        next = null;
    }
}

public class 环形链表 {
    public boolean hasCycle(ListNode3 head) {
        if(head==null) return false;
        //快指针追到慢指针说明有环
        ListNode3 slow=head;
        ListNode3 fast=head;
        while (fast!=null || fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast) return true;
        }
        return false;
    }

    
}
