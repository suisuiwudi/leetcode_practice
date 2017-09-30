package leetcode_220;

import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeSet;

class Solution {
    class Item {
        int index;
        int value;
        Item(int index, int value){
            this.index = index;
            this.value = value;
        }
    }
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k < 0) return false;
        if (t < 0) return false;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        Item[] numsItem = new Item[nums.length];
        for (int i = 0; i < nums.length; i++){
            numsItem[i] = new Item(i, nums[i]);
        }
        for (int i = 0 ; i < nums.length; i++){
            if (nums[i] > max) max = nums[i];
            if (nums[i] < min) min = nums[i];
        }

        HashMap<Integer, TreeSet<Item>> map = new HashMap();
        for (int i = 0; i < nums.length; i++){
            TreeSet<Item> set;
            if (i - k - 1 >= 0){
                //find the item should be removed based on bucket
                set = map.get( (int)((double) (nums[i - k - 1] -(double) min) / ((double)t + 1) ));
                set.remove(numsItem[i - k - 1]);
            }
            int bucketRank = (int) (  ((double)nums[i] - (double)min) /  ((double)t + 1));
            set = map.get(bucketRank);
            if (set == null){
                set = new TreeSet<Item>(new Comparator<Item>(){
                    public int compare(Item o1, Item o2){
                        if (o1.value == o2.value){
                            return o1.index - o2.index;
                        }
                        return (int) ((double) o1.value - (double) o2.value);
                    }
                });
            } 

            set.add(numsItem[i]);
            if (set.size() > 1) {
                return true;
            }
            
            TreeSet<Item> upperBucket = map.get(bucketRank + 1);
            if (upperBucket != null && upperBucket.size() > 0){
                if ((double)upperBucket.first().value - (double)set.last().value <= (double)t){
                    
                    return true;
                }
            }
            TreeSet<Item> lowerBucket = map.get(bucketRank - 1);
            if (lowerBucket != null && lowerBucket.size() > 0){
                if ((double)set.first().value - (double)lowerBucket.last().value <= (double)t){
                    return true;
                }
            }
            map.put(bucketRank,set);
        }
        return false;
    }
}
