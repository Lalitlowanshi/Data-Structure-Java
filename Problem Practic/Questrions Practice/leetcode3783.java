class Solution {
    public int mirrorDistance(int n) {
        int reverse = reverse(n);
        return Math.abs(reverse - n);
    }
    public int reverse(int n){
        int ans = 0;
        while(n != 0){
            ans = ans*10 + n%10;
            n /= 10;
        }
        return ans;
    }
}
