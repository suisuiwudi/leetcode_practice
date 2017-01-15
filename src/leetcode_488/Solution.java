package leetcode_488;

public class Solution {
    public int final_ans;
    public int findMinStep(String board, String hand) {
        final_ans = -1;
        dfs(board, hand, 0);
        return final_ans;
    }
    public int min(int a, int b){
        if ((a>b) || (a == -1)) return b; else return a;
    }
    public String renew(String old){
    	int flag=0;
    	while (flag != -1){
    		int first_pos=0;
    		int second_pos=-1;
    		for ( int i= 1; i<old.length();i++){
    			if (old.charAt(first_pos)==old.charAt(i)){
    				if (i-first_pos>1) second_pos=i;
    			}
    			else {
    				if (second_pos!=-1) break;
    				first_pos=i;
    			}
    		}
    		if (second_pos!=-1){
    			old = old.substring(0,first_pos)+old.substring(second_pos+1);
    			flag=0;
    		}else flag=-1;
    	}
    	return old;
    }
    public void dfs(String board, String hand, int num){
    	board = renew(board);
        if (board.length() == 0) {
            final_ans = min(final_ans,num);
            return;
        }
        for (int i = 1; i<board.length(); i++){
            if (board.charAt(i) == board.charAt(i-1)){
                for ( int j = 0; j<hand.length(); j++)
                if (hand.charAt(j) == board.charAt(i)){
                    String board_new = board.substring (0,i-1) + board.substring(i+1);
                    String hand_new = hand.substring(0,j) + hand.substring(j+1);
                    dfs(board_new,hand_new,num+1);
                }
            }
        }
        for (int i=0; i<board.length();i++){
            int same = 0;
            int first_pos=-1;
            int second_pos=-1;
            for ( int j=0; j<hand.length();j++){
                if (hand.charAt(j)==board.charAt(i))   {
                    if (first_pos==-1) first_pos=j; else second_pos=j; 
                    same++;
                    if (same == 2) {
//                    	System.out.println(board+" "+hand);
//                    	System.out.print(hand.charAt(j));
//                        System.out.print(i);
//                        System.out.println(j);
//                        System.out.print(first_pos);
//                        System.out.println(second_pos);
//                        System.out.println(same);
                        String board_new = board.substring(0,i)+board.substring(i+1);
                        String hand_new = hand.substring(0,first_pos)+hand.substring(first_pos+1,second_pos)+hand.substring(second_pos+1);
                        dfs(board_new,hand_new,num+2);
                    	break;
                    }
                 }
            }
        }
        return;
    }
}
