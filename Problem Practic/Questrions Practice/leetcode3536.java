class Solution {
    public int maxProduct(int n) {
        int max = 0;
        int second  = 0;
        int temp = 0;

        while(n != 0){
            temp = n%10;
            if(temp >= max){
                second = max;
                max = temp;
            }
            else if( temp > second){
                second = temp;
            }
            n /= 10;
        }
        return max*second;
    }
}
