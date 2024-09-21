package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class leetcode386 {
    public List<Integer> lexicalOrder(int n) {
        List <Integer> res = new ArrayList<>();
        for(int i=1; i<10; i++){
            if(i>n) break;
            dfs(i,n,res);
        }
        return res;
    }
    public void dfs(int curNum, int target, List<Integer> res){
        if(curNum>target){
            return;
        }
        res.add(curNum);
        for(int d=0;d<10;d++){
            if(curNum*10+d > target){
                break;
            }
            dfs(curNum*10+d,target,res);
        }
    }
}
