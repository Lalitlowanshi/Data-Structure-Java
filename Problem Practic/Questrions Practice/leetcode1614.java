class Solution {
    public int maxDepth(String s) {
        // Stack st = new Stack ();
        int count = 0;
        int n = s.length();
        int ans = 0;

        for(int i=0; i<n; i++){
            if(s.charAt(i) == '('){
                count++;
            }
            else if(s.charAt(i) == ')'){
                ans = Math.max(count,ans);
                count--;
            }
        }
        return ans;
    }
}
