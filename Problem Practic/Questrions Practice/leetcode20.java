class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack <>();
        int n = s.length();

        for(int i=0; i<n; i++){
            int c = s.charAt(i);
            if(c == '(')
                st.push(')');
            else if(c == '[')
                st.push(']');
            else if(c == '{')
                st.push('}');
            else if(st.isEmpty() || st.peek() != c){
                return false;
            }
            else{
                st.pop();
            }
        }
        return st.isEmpty();
    }
}


// Wrong Logic...
// class Solution {
//     public boolean isValid(String s) {
//         int ans = 0;
//         int n = s.length();
//         int smallCount = 0;
//         int curlyCount = 0;
//         int squareCount = 0;

//         if(n%2 != 0)
//             return false;

//         for(int i=0; i<n; i++){
//             if(s.charAt(i) == '('){
//                 smallCount++;
//             }
//             else if(s.charAt(i) == '{'){
//                 curlyCount++;
//             }
//             else if(s.charAt(i) == '['){
//                 squareCount++;
//             }
            
//             if(s.charAt(i) == ')'){
//                 ans++;
//                 smallCount--;
//             }
//             else if(s.charAt(i) == '}'){
//                 ans++;
//                 curlyCount--;
//             }
//             else if(s.charAt(i) == ']'){
//                 squareCount--;
//             }
//         }
//         if(smallCount == 0 && curlyCount == 0 && squareCount == 0)
//             return true;
//         return false;
//     }
// }
