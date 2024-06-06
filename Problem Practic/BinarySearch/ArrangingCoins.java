// https://leetcode.com/problems/arranging-coins/description/


class Solution {
    public int arrangeCoins(int n) {
        int count = 0;
        while(n>count){
            count++;
            n = n-count;
        }
        return count;
    }
}
