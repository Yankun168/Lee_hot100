package easy;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/*
 方法一   HashSet的使用
 */
//Definition for singly-linked list.
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
     }
  }
public class 相交链表 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set=new HashSet<>();
        //将A表元素全部加入set中？为什么要用set，每个结点（Object）的地址都不一样，即使val相同，地址也不同
        while (headA!=null){
            set.add(headA);
            headA=headA.next;
        }
        //检查链表B中是否有A中的元素
        while (!set.contains(headB)){
            headB=headB.next;
            if (headB==null) return null; //无相交
        }
        return headB;
    }
}