/*
 * this class is to test some recent cases I am dealing with 
 * and it will always change 
 * if you want to look at the performance 
 * go to leetcode website and submit the code in other folder or make main() yourself 
 */
import java.util.Scanner;
import leetcode_488.*;
public class main_test {

    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	String board = sc.nextLine();
    	String hand = sc.nextLine();
    	Solution solution = new Solution();
    	sc.close();
    	System.out.println(solution.findMinStep(board, hand));  	
    }
}
