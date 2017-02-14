package leetcode_19;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int i = 1; 
        while (head.next!=null){
            head=head.next;
            i++;
        }
        int j = i - n + 1;
        i = 1; 
        head = dummy;
        while (head.next!=null){
            if (i==j) {
                head.next = head.next.next;
                break;
            }
            head = head.next;
            i++;        
        }
        return dummy.next;
    }
}