package leetcode_582;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution {
    class PID{
        List<Integer> children;
        int val;
        PID(int val){this.val = val; children = new LinkedList();}
    }
    private Map<Integer, PID> pids;
    private List<Integer> ans;
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        pids = new HashMap();
        for (int i = 0; i < pid.size(); i++){
            if (pids.get(pid.get(i)) == null){
                pids.put(pid.get(i), new PID(pid.get(i)));
            }
            if (pids.get(ppid.get(i)) == null){
                pids.put(ppid.get(i), new PID(ppid.get(i)));
            }
            pids.get(ppid.get(i)).children.add(pid.get(i));
        }
        ans = new ArrayList();
        helper(0, kill, false);
        return ans;
    }
    public void helper(int pid, int kill, boolean startKill){
        if (pid == kill){
            startKill = true;
        }
        if (startKill) ans.add(pid);
        Iterator iter = pids.get(pid).children.iterator();
        while (iter.hasNext()){
            helper((int)iter.next(), kill, startKill);
        }
    }
}