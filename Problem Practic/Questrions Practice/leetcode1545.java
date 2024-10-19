class Solution {
    public char findKthBit(int n, int k) {
        StringBuilder s = new StringBuilder("0");
        
        for (int i = 2; i <= n; i++) {
          
            StringBuilder temp = new StringBuilder(s);
            
            for (int j = 0; j < temp.length(); j++) {
                temp.setCharAt(j, temp.charAt(j) == '0' ? '1' : '0');
            }
            temp.reverse();
            
            s.append("1").append(temp);
        }
        
        return s.charAt(k - 1);
    }
}
