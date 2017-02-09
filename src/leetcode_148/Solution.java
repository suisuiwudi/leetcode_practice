package leetcode_148;



/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode prep = null;
        ListNode slow = head;
        ListNode fast = head;

        while(fast!=null && fast.next != null){
            prep = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prep.next = null;
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);
        ListNode l = new ListNode(0);
        prep = l;
        while (l1 != null && l2 != null){
            if (l1.val < l2.val){
                prep.next = l1;
                l1 = l1.next;
            }else{
                prep.next = l2;
                l2 = l2.next;
            }
            prep = prep.next;
        }
        if (l1 != null)
            prep.next = l1;
        if (l2 != null)
            prep.next = l2;
        return l.next;
    }
}
