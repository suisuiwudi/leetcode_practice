package leetcode_599;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        List<String> ans = new ArrayList();
        for (int i = 0; i < list1.length+list2.length; i++){
            boolean find = false;
            for (int j = Math.max(0, i - list2.length + 1); j < Math.min(i + 1, list1.length); j++){
                if (list1[j].equals(list2[i - j])){
                    ans.add(list1[j]);
                    find =true;
                }
            }
            if (find) break;
        }
        int i = 0;
        String[] ansArr = new String[ans.size()];
        for (String str : ans){
            ansArr[i++] = str;
        }
        return ansArr;
    }
}