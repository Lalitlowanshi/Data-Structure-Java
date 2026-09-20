class Solution {
    public int reverseDegree(String s) {
        int n = s.length();
        int ans = 0;

        for(int i=0; i<n; i++){
            int temp = Math.abs(s.charAt(i) - 'a' - 26);
            ans += (temp * (i+1));
        }
        return ans;
    }
}
