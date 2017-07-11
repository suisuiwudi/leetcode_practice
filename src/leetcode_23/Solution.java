package leetcode_23;


import java.util.Comparator;
import java.util.PriorityQueue;

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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        PriorityQueue<ListNode> PQ = new PriorityQueue<ListNode>(new Comparator<ListNode>(){
            public int compare(ListNode o1, ListNode o2){
                return o1.val - o2.val;
            }
        });
        for (ListNode node : lists){
            if (node != null)
                PQ.add(node);
        }
        while (PQ.size() > 1){
            ListNode tmp = PQ.poll();
            dummy.next = tmp;
            if (tmp.next != null)
                PQ.add(tmp.next);
            dummy = dummy.next;
        }
        dummy.next = PQ.poll();
        return head.next; 
    }
}