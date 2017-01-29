package leetcode_2;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode((l1.val + l2.val) % 10);
        int add = (l1.val + l2.val) / 10;
        ListNode p = ans;
        while (l1.next != null || l2.next != null || add != 0){
            
            int a;
            int b;
            if (l1.next == null) a = 0;
            else{
                a = l1.next.val;
                l1 = l1.next;
            } 
            if (l2.next == null) b = 0;
            else {
                b = l2.next.val;
                l2 = l2.next;
            }
            p.next = new ListNode((a+b+add) % 10);
            add = (a+b+add) / 10;
            p = p.next;
        }
        return ans;
    }
}