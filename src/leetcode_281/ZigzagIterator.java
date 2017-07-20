package leetcode_281;

import java.util.ArrayList;
import java.util.List;

public class ZigzagIterator {
    int index_v1;
    int index_v2;
    int listorder;
    List<Integer> v1,v2;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        index_v1 = 0;
        index_v2 = 0;
        listorder = 0;
        this.v1 = new ArrayList(v1);
        this.v2 = new ArrayList(v2);
    }

    public int next() {
        if (index_v1 < v1.size() && index_v2 < v2.size()){
            listorder = 1 - listorder;
            if (listorder == 1){
                return v1.get(index_v1++);
            } else {
                return v2.get(index_v2++);
            }
            
        }
        if (index_v1 < v1.size()){
            return v1.get(index_v1++);
        }
        if (index_v2 < v2.size()){
            return v2.get(index_v2++);
        }
        return -1;
    }

    public boolean hasNext() {
        return index_v1 < v1.size() || index_v2 < v2.size();
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */