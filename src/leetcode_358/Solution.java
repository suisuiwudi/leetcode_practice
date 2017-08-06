package leetcode_358;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public class Item {
        int count;
        int last;
        int ch;
        public Item(int ch, int k){
            count = 0;
            last = -k;
            this.ch = ch;
        }
    }
    public String rearrangeString(String s, int k) {
        if ( k == 0 ) return s;
        Item[] items = new Item[26];
        for (int i = 0; i < 26; i++){
            items[i] = new Item(i,k);
        }
        PriorityQueue<Item> PQ = new PriorityQueue<Item>(new Comparator<Item>(){
            public int compare(Item o1, Item o2){
                if (o1.count == o2.count) return o1.ch - o2.ch;
                return o2.count - o1.count;
            }
        });
        
        for (int i = 0; i < s.length(); i++){
            items[s.charAt(i) - 'a'].count++;
        }
        for (int i = 0; i < 26; i++) {
            if (items[i].count > 0){
                PQ.add(items[i]);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++){
            if (i - k >= 0 && items[sb.charAt(i - k) - 'a'].count > 0 ) {
                PQ.add(items[sb.charAt(i - k) - 'a']);
            }
            if (PQ.size() == 0){
                return "";
            } else {
                Item item = PQ.poll();
                sb.append( (char) (item.ch+'a'));
                item.count--;
                item.last = i;
            }
        }
        return sb.toString();
    }
}
