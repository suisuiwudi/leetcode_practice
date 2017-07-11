package leetcode_82;

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
        ListNode pre = dummy;
        while (dummy.next != null){
            if (dummy.next.next != null && dummy.next.val == dummy.next.next.val){
                ListNode diff = dummy.next.next.next;
                while(diff != null && diff.val == dummy.next.val){
                    diff = diff.next;
                }
                dummy.next = diff;
            } else
                dummy = dummy.next;
        }
        return pre.next;
    }
}