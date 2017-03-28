package leetcode_79;

public class Solution {
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (search(board,word,0,i,j)){
                    return true;
                }
        return false;
    }
    public boolean search(char[][] board, String word, int index, int i, int j){
        if (word.length() == index) return true;
        int n = board.length;
        int m = board[0].length;
        if ( i < 0 || j < 0 || i == n || j == m) return false;
        if (word.charAt(index) != board[i][j]) return false;
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
        char tmp = board[i][j];
        board[i][j] = '.';
        boolean findFlag = false;
        for (int k = 0; k < 4; k++) 
            if (!findFlag){
            findFlag |= search(board,word,index+1,i+dx[k],j+dy[k]);
        }
        board[i][j] = tmp;
        return findFlag;
    }
}