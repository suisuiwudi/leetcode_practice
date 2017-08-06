package leetcode_346;

import java.util.Deque;
import java.util.LinkedList;

public class MovingAverage {

    /** Initialize your data structure here. */
    private Deque<Integer> queue;
    private int num;
    private int sum;
    public MovingAverage(int size) {
        queue = new LinkedList();
        num = size;
    }
    
    public double next(int val) {
        sum += val;
        queue.addLast(val);
        if (queue.size() > num){
            sum -= queue.removeFirst();
        }
        return (double) sum/queue.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */