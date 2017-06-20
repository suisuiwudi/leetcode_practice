package leetcode_143;

import data_structure.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return; 
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode midPre = slow;
        ListNode halfP = slow.next;
        while (halfP.next != null){
            ListNode tmp = midPre.next;
            midPre.next = halfP.next;
            halfP.next = halfP.next.next;
            midPre.next.next = tmp;
        }
        ListNode start = head;
        while (start.next != null && start.next.next !=null){
            ListNode tmp = start.next;
            start.next = midPre.next;
            midPre.next = midPre.next.next;
            start.next.next = tmp;
            start = start.next.next;
        }
    }
}