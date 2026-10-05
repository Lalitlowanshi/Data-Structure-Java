class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        int n = s.length();
        st.push(0);

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                st.push(0);
            } else {
                int v = st.pop();

                int score;
                if(v == 0){
                    score = 1;
                }else{
                    score = 2*v;
                }
                st.push(st.pop()+score);
            }

        }
        return st.pop();
    }
}



// Another way to solve


// class Solution {
//     public int scoreOfParentheses(String s) {
//         Stack<Integer> st = new Stack<>();
//         st.push(0);

//         for (char ch : s.toCharArray()) {
//             if (ch == '(') {
//                 st.push(0);
//             } else {
//                 int v = st.pop();
//                 int score = (v == 0) ? 1 : 2 * v;
//                 st.push(st.pop() + score);
//             }
//         }

//         return st.pop();
//     }
// }
