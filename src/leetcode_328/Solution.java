package leetcode_328;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        ListNode dummy = new ListNode(0);
        if (head == null || head.next == null) return head;
        dummy.next = head;
        ListNode tail = head;
        while (tail.next!=null &&tail.next.next!=null){
            tail = tail.next.next;
        }
        
        ListNode evenTail = tail;
        ListNode lastNumber = tail.next;
        while (head != tail){
            ListNode tmp = head.next.next;
            evenTail.next = head.next;
            head.next = tmp;
            evenTail = evenTail.next;
            evenTail.next = lastNumber;
            head = head.next;
        }
        return dummy.next;
    }
}