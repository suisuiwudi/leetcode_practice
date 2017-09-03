package leetcode_502;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    class Item{
        int profit;
        int capital;
        public Item(int profit, int capital){
            this.profit = profit;
            this.capital = capital;
        }
    }
    class ProfitComparator implements Comparator<Item>{
        public int compare(Item o1, Item o2){
            return o2.profit - o1.profit;
        }
    }
    class CapitalComparator implements Comparator<Item>{
        public int compare(Item o1, Item o2){
            return o2.capital - o1.capital;
        }
    }
    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        int done = 0;
        PriorityQueue<Item> PQ = new PriorityQueue(new ProfitComparator());
        
        ArrayList<Item> list = new ArrayList();
        for (int i = 0; i < Capital.length; i++){
            list.add(new Item(Profits[i],Capital[i]));
        }
        Collections.sort(list, new CapitalComparator());
        int listIndex = Capital.length - 1;
        while (done < k && done < Profits.length){
            for (; listIndex >= 0; listIndex--){
                if (list.get(listIndex).capital > W){ 
                    break;
                }
                PQ.add(list.get(listIndex));
            }
            Item maxItem = PQ.poll();
            if (maxItem == null) break;
            W += maxItem.profit;
            done++;
            
        }
        return W;
    }
}