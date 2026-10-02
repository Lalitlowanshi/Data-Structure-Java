class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();

        Queue<String> queue = new LinkedList<>();
        queue.offer("");

        for (int i = 0; i < 2 * n; i++) {
            int size = queue.size();

            while (size-- > 0) {
                String s = queue.poll();

                int open = 0;
                int close = 0;

                for (char ch : s.toCharArray()) {
                    if (ch == '(') {
                        open++;
                    } else {
                        close++;
                    }
                }
                if (open < n) {
                    queue.offer(s + "(");
                }
                if (close < open) {
                    queue.offer(s + ")");
                }
            }
        }
        ans.addAll(queue);

        return ans;
    }
}



// By Backtracking approach...

// class Solution {
//     public List<String> generateParenthesis(int n) {
//         List<String> ans = new ArrayList<>();

//         backtrack("",0,0,n,ans);

//         return ans;
//     }

//     private void backtrack(String s, int open, int close, int n, List<String> ans){
//         if(s.length() == 2*n){
//             ans.add(s);
//             return;
//         }
//         if(open < n){
//             backtrack(s+"(", open+1, close, n, ans);
//         }
//         if(close < open){
//             backtrack(s+")", open, close+1, n, ans);
//         }
//     }
// }
