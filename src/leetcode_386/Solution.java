package leetcode_386;

import java.util.ArrayList;
import java.util.List;
import java.lang.Thread;

class Solution {
    public List<Integer> lexicalOrder(int n) throws InterruptedException {
        int next = 1;
        List<Integer> list = new ArrayList();
        for (int i = 0; i < n; i++){
            list.add(next);
            if (next * 10 <= n){
                next *= 10;
            } else if (next + 1 <= n && next % 10 != 9){
                next++;
            } else {
                while ((next / 10) % 10 == 9){
                    next = next / 10;
                }
                next = next / 10 + 1;
            }
        }
        return list;
    }
    
}
