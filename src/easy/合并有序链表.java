package easy;

import java.util.ArrayList;
import java.util.List;

/*
  使用带头结点的链表，这样方便区分头指针和当前访问的指针。
 */
class ListNode4 {
    int val;
    ListNode4 next;
    ListNode4() {}
    ListNode4(int val) { this.val = val; }
    ListNode4(int val, ListNode4 next) { this.val = val; this.next = next; }
}
public class 合并有序链表 {
    public ListNode4 mergeTwoLists(ListNode4 list1, ListNode4 list2) {
        ListNode4 dummyNode=new ListNode4();
        ListNode4 cur=dummyNode;
        while (list1!=null && list2!=null){
            if(list1.val<= list2.val){
                cur.next=list1;
                list1=list1.next;
            }else {
                cur.next=list2;
                list2=list2.next;
            }
            cur=cur.next;
        }
        cur.next=list1==null?list2:list1;
        return dummyNode.next;
    }
}
