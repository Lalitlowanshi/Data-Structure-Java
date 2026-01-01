class Solution {
    public int longestPalindrome(String s) {
        HashSet <Character> set = new HashSet<>();
        int n = s.length();
        int count = 0;
        int ans = 0;
        boolean trigger = false;

        if(n <= 1){
            return n;
        }
        for(int i=0; i<n-1; i++){
            if(set.contains(s.charAt(i))){
                continue;
            }else{
                set.add(s.charAt(i));
            }
            for(int j=i+1; j<n; j++){
                if(s.charAt(i) == s.charAt(j)){
                    count++;
                }
            }
            count++; // increment for main i th value;

            if(count % 2 == 0){
                ans += count;
            }else{
                trigger = true;
                ans += count - 1;
            }
            count = 0;
        }
        if(trigger){
            return ans+1;
        }
        else{
            return ans;
        }
    }
}
