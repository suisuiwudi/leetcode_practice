package leetcode_147;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0);
       // System.out.println(head.val);
        dummy.next = head;
        if (head == null || head.next == null) return head;
        while (head.next !=null){
            ListNode find = dummy;
            while (find.next !=null && find != head && head.next.val > find.next.val){
                find = find.next;
            }
            if (find != head){  
                ListNode tmp = head.next.next;
                head.next.next = find.next;
                find.next = head.next;            
                head.next = tmp;
            }else{
                head=head.next;
            }

        }
        return dummy.next;
    }
}