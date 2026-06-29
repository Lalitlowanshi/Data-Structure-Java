class Solution {
    public int numOfStrings(String[] patterns, String word) {
        int count = 0;

        for (String p : patterns) {
            if (word.contains(p)) {
                count++;
            }
        }

        return count;
    }
}

// class Solution {
//     public int numOfStrings(String[] patterns, String word) {
//         int ans = 0;
//         int m = word.length();

//         for (String p : patterns) {
//             int len = p.length();
//             boolean found = false;

//             // Try every starting position in word
//             for (int i = 0; i <= m - len; i++) {
//                 int j = 0;

//                 // Compare characters
//                 while (j < len && word.charAt(i + j) == p.charAt(j)) {
//                     j++;
//                 }

//                 // Entire pattern matched
//                 if (j == len) {
//                     found = true;
//                     break;
//                 }
//             }

//             if (found) {
//                 ans++;
//             }
//         }

//         return ans;
//     }
// }
