package leetcode_542;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public List<List<Integer>> updateMatrix(List<List<Integer>> matrix) {
        int n = matrix.size();
        int m = matrix.get(0).size();
        Queue<int[]> queue = new LinkedList();
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (matrix.get(i).get(j) == 0){
                    queue.add(new int[] {i , j});
                } else{
                    matrix.get(i).set(j, Integer.MAX_VALUE);
                }
            }
        }
        int[][] direc ={{0,-1},{0,1},{1,0},{-1,0}};
        while (!queue.isEmpty()){
            int[] head = queue.poll();
            for (int[] d : direc){
                int x = head[0] + d[0];
                int y = head[1] + d[1];
                if (x < 0 || x >= n || y < 0 || y >=m || matrix.get(x).get(y) <=matrix.get(head[0]).get(head[1]) + 1) 
                    continue;
                int tmp = matrix.get(head[0]).get(head[1]) + 1;
                queue.add(new int[] {x , y});
                matrix.get(x).set(y, tmp);
            }
        }
        return matrix;
    }
}