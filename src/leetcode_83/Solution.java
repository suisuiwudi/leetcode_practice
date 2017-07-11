package leetcode_83;

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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        while (head.next != null){
            if (head.val == head.next.val)
                head.next = head.next.next;
            else
                head = head.next;
        }
        return dummy.next;
    }
}