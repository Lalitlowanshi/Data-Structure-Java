class Solution {
    public boolean checkString(String s) {
        int n = s.length();
        boolean b = false;

        for(int i=0; i<n; i++){
            if(s.charAt(i) == 'b'){
                b = true;
            }
            if(b && s.charAt(i) == 'a'){
                return false;
            }
        }
        return true;
    }
}
