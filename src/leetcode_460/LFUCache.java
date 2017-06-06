package leetcode_460;

import java.util.HashMap;
import java.util.LinkedHashSet;

public class LFUCache {
    HashMap<Integer, Integer> vals;
    HashMap<Integer, Integer> counts;
    HashMap<Integer, LinkedHashSet<Integer>> valsByFreq;
    int capacity;
    int min = -1;
    public LFUCache(int capacity) {
        this.capacity = capacity;
        vals = new HashMap();
        counts = new HashMap();
        valsByFreq = new HashMap();
        valsByFreq.put(1, new LinkedHashSet());
    }
    
    public int get(int key) {
        if (!vals.containsKey(key))
            return -1;
        int count = counts.get(key);
        counts.put(key, count + 1);
        
        valsByFreq.get(count).remove(key);
        if (!valsByFreq.containsKey(count + 1)){
            valsByFreq.put(count + 1, new LinkedHashSet());
        }
        valsByFreq.get(count + 1).add(key);
        
        if (valsByFreq.get(count).size() == 0 && min == count){
            min++;
        }
        return vals.get(key);
    }
    
    public void put(int key, int value) {
        if (capacity == 0) return;
        if (vals.containsKey(key)){
            vals.put(key, value);
            get(key);
            return;
        }
        if (vals.size() == capacity){
            int evitInt = valsByFreq.get(min).iterator().next();
            vals.remove(evitInt);
            valsByFreq.get(min).remove(evitInt);
        }
        min = 1;
        vals.put(key,value);
        counts.put(key, 1);
        valsByFreq.get(1).add(key);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */