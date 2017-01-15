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
