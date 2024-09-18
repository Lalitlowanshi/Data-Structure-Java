package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class leetcode884 {
        public String[] uncommonFromSentences(String s1, String s2) {
        HashMap<String, Integer> map = new HashMap<>();
        // s1 = s1 + " " + s2;
        for(String word : s1.split(" ")){
            map.put(word, map.getOrDefault(word,0)+1);
        }
        for(String word : s2.split(" ")){
            map.put(word, map.getOrDefault(word,0)+1);
        }
        ArrayList<String> list = new ArrayList<>();
        for(Map.Entry<String,Integer> entry :map.entrySet()){
            if(entry.getValue() == 1){
                list.add(entry.getKey());
            }
        }
        String res [] = new String[list.size()];
        list.toArray(res);
        return res;
    }
    
}