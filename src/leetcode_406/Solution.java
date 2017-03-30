package leetcode_406;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Solution {
    public int[][] reconstructQueue(int[][] people) {
        int n = people.length;
        int m = 2;
        Arrays.sort(people, new Comparator<int[]>(){
            public int compare(int[] o1, int[] o2){
                if (o1[1] != o2[1])
                    return o1[1] - o2[1];
                else
                  return o1[0] - o2[0];
            }
            });
        List<int[]> ansList = new LinkedList();
        for (int i = 0; i < n; i++){
            ListIterator list = ansList.listIterator();
            int p = 0;
            while (p < people[i][1] && list.hasNext()){
                int[] tmp = (int[]) list.next();
                if (people[i][0] <= tmp[0])
                    p++;
            }
            while (list.hasNext()){
                int[] tmp = (int[]) list.next();
                list.previous();
                if (people[i][0] < tmp[0]) break;
                else list.next();
            }
            list.add(people[i]);
        }
        ListIterator list = ansList.listIterator();
        int[][] ans = new int[n][2];
        int i = 0;
        while (list.hasNext()){
            ans[i++] = (int[])list.next();
            
        }
        return ans;
    }
}