class Solution {
    public int numberOfSubstrings(String s) {
        int[] cnt = new int[3];
        int left = 0;
        int ans = 0;

        for (int right = 0; right < s.length(); right++) {
            cnt[s.charAt(right) - 'a']++;

            while (cnt[0] > 0 && cnt[1] > 0 && cnt[2] > 0) {
                ans += s.length() - right;
                cnt[s.charAt(left) - 'a']--;
                left++;
            }
        }

        return ans;
    }
}



// class Solution {
//     public int numberOfSubstrings(String s) {
//         int n = s.length();
//         int count = 0;

//         for(int i=0; i<n; i++){

//             for(int j=i+1; j<=n; j++){
//                 String sub = s.substring(i,j);

//                 if(sub.contains("a") && sub.contains("b") && sub.contains("c")){
//                     count++;
//                 }
//             }
//         }
//         return count;
//     }
// }
