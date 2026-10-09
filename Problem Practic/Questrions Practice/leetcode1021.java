class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder ans = new StringBuilder();
        int depth = 0;

        for(char ch : s.toCharArray()){
            if(ch == '('){
                if(depth > 0){
                    ans.append(ch);
                }
                depth++;
            }
            else{
                depth--;

                if(depth > 0){
                    ans.append(ch);
                }
            }
        }
        return ans.toString();
    }
}






// Direct, Simple & Easy to Understand Solution....


// class Solution {
//     public String removeOuterParentheses(String s) {
//         int n = s.length();
//         int count = 0;
//         StringBuilder sb = new StringBuilder();

//         for(char ch : s.toCharArray()){
//             if(count == 0 && ch == '('){
//                 count++;
//                 continue;
//             }
//             if(count == 1 && ch == ')'){
//                 count--;
//                 continue;
//             }
//             if(ch == '('){
//                 count++;
//                 sb.append(ch);
//             }
//             if(ch == ')'){
//                 count--;
//                 sb.append(ch);
//             }
//         }
//         return sb.toString();
//     }
// }
