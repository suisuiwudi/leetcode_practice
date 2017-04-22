package leetcode_130;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        if (n == 0) return;
        int m = board[0].length;
        if (m == 0) return;
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList();
        for (boolean[] row : visited){
            Arrays.fill(row,false);
        }
        for (int i = 0; i < n; i++){
            if (!visited[i][0] && board[i][0] == 'O'){
                visited[i][0] = true;
                queue.add(new int[]{i,0});
            }
            if (!visited[i][m-1] && board[i][m-1] == 'O'){
                visited[i][m-1] = true;
                queue.add(new int[]{i,m-1});
            }
        }
        for (int i = 0; i < m; i++){
            if (!visited[0][i] && board[0][i] == 'O'){
                visited[0][i] = true;
                queue.add(new int[]{0,i});
            }
            if (!visited[n-1][i] && board[n-1][i] == 'O'){
                visited[n-1][i] = true;
                queue.add(new int[]{n-1,i});
            }
        }
        int[] dx ={1,-1,0,0};
        int[] dy ={0,0,1,-1};
        while (!queue.isEmpty()){
            int[] tmp = queue.poll();
            board[tmp[0]][tmp[1]] = '1';
            for (int k = 0; k < 4; k++){
                int[] next = {tmp[0] + dx[k], tmp[1] + dy[k]};
                if (next[0] < 0 || next[0] >=n || next[1] < 0 || next[1] >=m ) continue;
                if (visited[next[0]][next[1]] || board[next[0]][next[1]] == 'X') continue;
                if (board[next[0]][next[1]] == 'O') {
                    queue.add(next);
                    visited[next[0]][next[1]] = true;
                }
            }
        }
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (board[i][j] == '1')
                    board[i][j] = 'O';
                else 
                    board[i][j] = 'X';
            }
        }
    }
}
