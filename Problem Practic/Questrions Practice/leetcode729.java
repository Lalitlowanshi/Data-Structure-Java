package Leetcode;

import java.util.TreeMap;

public class leetcode729 {
    class MyCalendar {
    TreeMap<Integer,Integer> map;
    public MyCalendar() {
        map = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        Integer prevVal = map.lowerKey(end);
        if(prevVal!=null && start <= map.get(prevVal)-1){
            return false;
        }
        map.put(start,end);
        return true;
    }
}

}
