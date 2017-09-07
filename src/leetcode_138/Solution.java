package leetcode_138;

import data_structure.RandomListNode;

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;
        RandomListNode cur = head;
        while (cur != null){

            RandomListNode temp = new RandomListNode(cur.label);
            temp.next = cur.next;
            cur.next = temp;
            cur = cur.next.next;
        }
        cur = head;
        while (cur != null){
            if (cur.random != null) cur.next.random = cur.random.next;
            cur = cur.next.next;
        }
        RandomListNode newhead = head.next;
        RandomListNode cur1 = head;
        RandomListNode cur2 = head.next;
        while (cur1 != null){
            cur1.next = cur2.next;
            if (cur1.next != null) cur2.next = cur1.next.next;
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return newhead;
    }
}
