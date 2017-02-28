package leetcode_451;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Solution {
    public String frequencySort(String s) {
        if (s.length() == 0) return s;
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        for (int i = 0; i < s.length(); i++){
            int tmp = 1;
            if (map.containsKey(s.charAt(i))){
                tmp += map.get(s.charAt(i));
            }
            map.put(s.charAt(i),tmp);
        }
        PriorityQueue<String> heap = new PriorityQueue<String>(map.size(),
            new Comparator<String>(){
                public int compare(String o1, String o2){
                    return o2.length() - o1.length();
                }
            });
 
        for (char ch : map.keySet()){
            StringBuilder sb = new StringBuilder(map.get(ch));
            for ( int i = 0; i < map.get(ch); i++){
                sb.append(ch);
            }
            heap.add(sb.toString());
        }
        StringBuilder sb = new StringBuilder();
        while (!heap.isEmpty()){
            sb.append(heap.poll());
        }
        return sb.toString();
    }
}