package leetcode_86;

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
    public ListNode partition(ListNode head, int x) {
        ListNode ans = new ListNode(0);
        ListNode pNew = ans;
        ListNode pOriginal = head;
        while (pOriginal!=null){
            if (pOriginal.val < x){
                pNew.next = new ListNode(pOriginal.val);
                pNew = pNew.next;
            }
            pOriginal = pOriginal.next;
        }
        pOriginal = head;
        while (pOriginal!=null){
            if (pOriginal.val >= x){
                pNew.next = new ListNode(pOriginal.val);
                pNew = pNew.next;
            }
            pOriginal = pOriginal.next;
        }
        return ans.next;
    }
}