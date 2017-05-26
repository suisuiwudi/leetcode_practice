package leetcode_399;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    class Edge{
        double val;
        Node next;
        Node pre;
        Edge(double val, Node pre, Node next){
            this.val = val;
            this.pre = pre;
            this.next = next;
        }
    }
    class Node{
        LinkedList<Edge> next;
        String var;
        double val;
        Node(String var){this.var = var; next = new LinkedList();}
        public void addNext(Node next, double val){
            this.next.add(new Edge(val, this, next));    
        }
    }
    private HashMap<String, Node> map;
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        map = new HashMap();
        for (int i = 0; i < equations.length;i++){
            if (!map.containsKey(equations[i][0])){
                map.put(equations[i][0],new Node(equations[i][0]));    
            }
            if (!map.containsKey(equations[i][1])){
                map.put(equations[i][1],new Node(equations[i][1]));
            }
            Node a = map.get(equations[i][0]);
            Node b = map.get(equations[i][1]);
            a.addNext(b,values[i]);
            b.addNext(a,1/values[i]);
        }
        double ans[] = new double[queries.length];
        for (int i = 0; i < queries.length;i++){
            ans[i] = search(map.get(queries[i][0]),map.get(queries[i][1]));
        }
        return ans;
        
    }
    public double search(Node start, Node end){
        if (start == null) return -1.0;
        if (end == null) return -1.0;
        HashSet<String> visited = new HashSet();
        Queue<Node> queue = new LinkedList();
        end.val = -1.0;
        start.val = 1.0;
        visited.add(start.var);
        queue.add(start);
        while (!queue.isEmpty()){
            Node now = queue.poll();
            for (Edge edge : now.next){
                if (!visited.contains(edge.next.var)){
                    edge.next.val = now.val * edge.val;
                    queue.add(edge.next);
                    visited.add(edge.next.var);
                }
            }
        }
        return end.val;
    }
}