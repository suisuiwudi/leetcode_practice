package leetcode_321;

public class Solution {
    public int[] max(int[] a, int[]b){
    	if (a.length == 0) return b;
    	for (int i=0; i<a.length; i++)
    		if (a[i]>b[i]) return a;
    		else if (a[i]<b[i]) return b;
    	return a;
    }
    public int[] merge(int[] a, int[] b, int klength){
    	if (a.length==0) return b;
    	if (b.length==0) return a;
    	int[] ans = new int[klength];
    	int j=0, k=0;
    	for (int i=0; i<klength && j<a.length && k<b.length;i++) {
    		boolean chooseb = false;
    		for (int l=0;j+l<=a.length && k+l<=b.length;l++){
        		if (j+l == a.length) { chooseb=true; break; }
        		else if (k+l == b.length) break; 
    			if (a[j+l]>b[k+l]){
	    			break;
	    		}else if (a[j+l]<b[k+l]){
	    			chooseb = true;
	    			break;    		
	    		}
    		}

    		if (chooseb) 
    			ans[j+k]=b[k++];
    		else
    			ans[j+k]=a[j++];
    	}
    	for (;j<a.length;j++) ans[j+k]=a[j];
    	for (;k<b.length;k++) ans[j+k]=b[k];
//    		System.out.println(a+a.charAt(1));

    	return ans;
    }
    public int[] maxSingleArrayofK(int[] a, int k){
    	int[] ans = new int[k];
    	int length = 0;
    	for (int i = 0; i < a.length; i++){
    		while (length>0 && length+a.length-i>k && ans[length-1]<a[i]) length--;
    		if (length<k)
    			ans[length++]=a[i];
    	}
    	return ans;
    }
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int n=nums1.length;
        int m=nums2.length;
        long a=System.currentTimeMillis();
//    	System.out.println("\r<br>执行耗时 : "+(System.currentTimeMillis()-a)/1000f+" 秒 ");
        int[] ans = new int[k];
        for (int i=0; i<=k; i++)
        	if (i<=n && k-i<=m){
        		ans= max(ans,merge(maxSingleArrayofK(nums1,i),maxSingleArrayofK(nums2,k-i),k));
        	}
//        for (int i=0; i<k; i++)
//        	System.out.println(ans[i]);       
        return ans;
    }
}