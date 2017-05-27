package leetcode_310;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {   
    class Edge{
        Node next;
        Node pre;
        Edge(Node pre, Node next){
            this.pre = pre;
            this.next = next;
        }
    }
    class Node{
        LinkedList<Edge> next;
        int v;
        int degree;
        int step;
        Node(int v){this.v = v; next = new LinkedList(); step = 0;}
        public void addNext(Node next){
            this.next.add(new Edge(this, next));    
            this.degree++;
        }
    }
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        Node[] nodes = new Node[n];
        if (n == 1) return Collections.singletonList(0);
        for (int i = 0; i < n - 1;i++){
            if (nodes[edges[i][0]] == null){
                nodes[edges[i][0]] = new Node(edges[i][0]);
            }
            if (nodes[edges[i][1]] == null){
                nodes[edges[i][1]] = new Node(edges[i][1]); 
            }
            Node a = nodes[edges[i][0]];
            Node b = nodes[edges[i][1]];
            a.addNext(b);
            b.addNext(a);
        }
        int scanned = 0;
        Queue<Integer> queue = new LinkedList();
        for (int i = 0; i < n; i++){
            if (nodes[i].degree == 1){
                nodes[i].step = 1;
                queue.add(i);
            }
        }
        int step = 0;
        
        while (!queue.isEmpty()){
            int now = queue.poll();
            scanned++;
            if (nodes[now].step != step){
                if (queue.size() + scanned == n){
                    List<Integer> ans = new ArrayList(queue);
                    ans.add(now);
                    return ans;
                }
                step++;
            }
            for (Edge edge : nodes[now].next){
                if (edge.next.degree > 1){
                    edge.next.degree--;
                    if (edge.next.degree == 1){
                        edge.next.step = nodes[now].step + 1;
                        queue.add(edge.next.v);
                    }
                }
            }
        }
        return null;
    }
}
