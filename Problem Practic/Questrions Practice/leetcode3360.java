class Solution {
    public boolean canAliceWin(int n) {
        int i = 10;
        while(i <= n){
            n -= i;
            i--;
        }
        
        if(i % 2 == 0){
            return false;
        }
        return true;
    }
}
