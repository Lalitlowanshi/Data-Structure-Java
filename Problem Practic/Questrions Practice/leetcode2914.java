
class Solution {
    public int minChanges(String s) {
        int count = 0;

        for(int i = 0; i < s.length(); i += 2) {
            if(s.charAt(i) != s.charAt(i + 1)) {
                count++;
            }
        }

        return count;
    }
}


// Wrong Solution (Over Thinking kills the simple logics)....

// class Solution {
//     public int minChanges(String s) {
//         int n = s.length();
//         int zero=0, one=0;

//         for(int i=0; i<n; i+=2){
//             if(s.charAt(i) == '0'){
//                 zero++;
//             }
//             else if(s.charAt(i) == '1'){
//                 one++;
//             }

//             if(s.charAt(i+1) == '0'){
//                 zero++;
//             }
//             else if(s.charAt(i+1) == '1'){
//                 one++;
//             }
            
//             if(zero == 0 || one == 0){
//                 zero = 0;
//                 one = 0;
//             }    
//         }
//         return Math.min(zero,one);
//     }
// }
