package leetcode_61;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head==null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        int length = 0;
         while (fast.next!=null){
            fast=fast.next;
            length++;
        }
        k = k%length;
        fast = dummy;
        while (k-->0){
            fast=fast.next;
            if (fast ==null) fast = dummy.next;
        }
        if (fast.next == null) return dummy.next;
        while (fast.next!=null){
            slow=slow.next;
            fast=fast.next;
        }
        fast.next = dummy.next;
        dummy.next = slow.next;
        slow.next =null;
        return dummy.next;
    }
}