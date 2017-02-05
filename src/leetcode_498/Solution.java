package leetcode_498;

public class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        int c = 0;
        int n = matrix.length;
        int[] a = new int[0];
        if (n == 0) return a;
        int m = matrix[0].length;
        int count = n+ m -1;
        int x = 0, y = 0;
        int countAns = 0;
        int[] ans = new int[n*m];
        
    	while (c < count) {
    		int i = x;
    		int j = y;
    		if (c % 2 == 0){
    		   while (i >=0 && j< matrix[0].length ) {
		        	ans[countAns++] = matrix[i][j];
		        	i--;
		        	j++;
	        	}
    		}else{
    		  while (i < matrix.length && j>=0 ) {
		        	ans[countAns++] = matrix[i][j];
		        	i++;
		        	j--;
	        	} 
    		}
    		if ( c % 2 == 0){
    		    if (c + 1>=matrix[0].length){
    		        y = matrix[0].length - 1;
    		        x = c - matrix[0].length + 2;
    		    }else{
    		        x = 0;
    		        y = c + 1;
    		    }
    		}else{
    		    if (c + 1>=matrix.length){
    		        x = matrix.length - 1;
    		        y = c - matrix.length + 2;
    		    }else{
    		        y = 0;
    		        x = c + 1;
    		    }
    		}

    		c++;
    	}
	return ans;
    }

}