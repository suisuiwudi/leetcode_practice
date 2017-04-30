package leetcode_332;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {
    public List<String> findItinerary(String[][] tickets) {
        Map<String, PriorityQueue<String>> flights = new HashMap();
        for (int i = 0; i < tickets.length; i++){
            if (!flights.containsKey(tickets[i][0])){
                flights.put(tickets[i][0], new PriorityQueue());
            }
            flights.get(tickets[i][0]).add(tickets[i][1]);
        }
        LinkedList<String> path = new LinkedList();
        search("JFK", path, flights);
        return path;
    }
    public void search(String departure, LinkedList<String> path, Map<String, PriorityQueue<String>> flights){
        
        PriorityQueue<String> arrivals = flights.get(departure);
        while (arrivals != null && !arrivals.isEmpty()){
            search(arrivals.poll(),path,flights);
        }
        path.addFirst(departure);
    }
}