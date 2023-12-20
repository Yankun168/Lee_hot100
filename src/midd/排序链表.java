package midd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 排序链表 {
    public ListNode sortList(ListNode head) {
        //被分的只有一个元素或者没有元素了。返回本身
        if (head == null || head.next == null)
            return head;
        //典型双指针找中点
        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode tmp = slow.next;
        slow.next = null;
        //拆成left开头和right开头的两个待合并链表
        ListNode left = sortList(head);
        ListNode right = sortList(tmp);
        ListNode h = new ListNode(0);
        ListNode res=h;
        //按顺序合并
        while (left != null && right != null) {
            if (left.val < right.val) {
                h.next = left;
                left = left.next;
            } else {
                h.next = right;
                right = right.next;
            }
            h = h.next;
        }
        //有一个链表已经合并完了
        h.next = left != null ? left : right;
        return res.next;
    }
}
