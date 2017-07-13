package leetcode_632;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Solution {
    private List<Integer> arrayNums;
    public int[] smallestRange(List<List<Integer>> nums) {
        TreeSet<Integer> set = new TreeSet();
        for (List<Integer> list : nums){
            for (int num : list){
                set.add(num);
            }
        }
        arrayNums = new ArrayList(set);
        int[] ans = {arrayNums.get(0), arrayNums.get(arrayNums.size()-1)};
        for (int i = 0; i < arrayNums.size(); i++){
            int left = i;
            int right = arrayNums.size() - 1;
            while (left <= right){
                int mid = (left + right) / 2;
                if (coverEveryone(nums,i,mid)){
                    if (arrayNums.get(mid) - arrayNums.get(i) < ans[1] - ans[0]){
                        ans[0] = arrayNums.get(i);
                        ans[1] = arrayNums.get(mid);
                    }
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return ans;
    }
    public boolean coverEveryone(List<List<Integer>> nums, int bLeft, int bRight){
        int boundLeft = arrayNums.get(bLeft);
        int boundRight = arrayNums.get(bRight);
        for (List<Integer> list : nums){
            int left = 0;
            int right = list.size() - 1;
            boolean cover = false;
            while (left <= right){
                int mid = (left + right) / 2;
                if (list.get(mid) >= boundLeft && list.get(mid) <= boundRight){
                    cover = true;
                    break;
                } else if (list.get(mid) > boundRight){
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            if (!cover) {
                return false;
            }
        }
        return true;
    }
}