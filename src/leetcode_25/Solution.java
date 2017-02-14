package leetcode_25;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = head;
        if (head == null || head.next ==null) return head;
            int num = 0;
            while (fast!=null){
                fast=fast.next;
                num++;
                if (num==k) break;
                
            }
            if (num!=k) return dummy.next;
            ListNode tail = reverseKGroup(fast,k);
            while (num-->0){
                ListNode tmp = head.next;
                head.next = tail;
                tail = head;
                head = tmp;
            }
            
         return tail;
    }
}