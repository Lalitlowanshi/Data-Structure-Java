// class Solution {
//     public int minimumPushes(String word) {
//         int n = word.length();
//         int ans = 0;

//         for (int i = 0; i < n; i++) {
//             ans += (i / 8) + 1;
//         }

//         return ans;
//     }
// }



class Solution {
    public int minimumPushes(String word) {
        int n = word.length();
        int ans = 0;

        if(n <= 8){
            ans = n;
        }
        else if( n <= 16){
            int temp = n%8;
            if(n%8 == 0){
                temp = 8;
            }
            ans += (temp*2)+8;
        }
        else if( n <= 24){
            int temp = n%8;
            if(n%8 == 0){
                temp = 8;
            }
            ans += (temp*3)+24;
        }
        else{
            int temp = n%8;
            ans += (temp*4)+48;
        }
        return ans;
    }
}
