package leetcode_142;

import data_structure.ListNode;

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        boolean cycle = false;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                cycle = true;
                break;
            }
        }
        if (!cycle) return null;
        slow = head;
        while (slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}