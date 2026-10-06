class Solution {
    public int minAddToMakeValid(String s) {
        int open = 0;
        int ans = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                open++;
            } else {
                if (open > 0) {
                    open--;
                } else {
                    ans++;
                }
            }
        }

        return ans + open;
    }
}




// Wrong Logic...

// class Solution {
//     public int minAddToMakeValid(String s) {
//         int n = s.length();
//         int open = 0;
//         int close = 0;
//         for(char ch : s.toCharArray()){
//             if(ch == '('){
//                 open++;
//             }
//             else{
//                 close++;
//             }
//         }
//         return Math.abs(open-close);
//     }
// }
