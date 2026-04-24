class Solution {
    public int furthestDistanceFromOrigin(String s) {
        int n = s.length();
        int l = 0;
        int r = 0;
        int b = 0;

        for(int i=0; i<n; i++){
            if(s.charAt(i) == 'L'){
                l++;
            }
            else if(s.charAt(i) == 'R'){
                r++;
            }
            else{
                b++;
            }
        }
        int ans = Math.abs(l-r)+b;
        return ans;
    }
}





// Wrong Logic

// class Solution {
//     public int furthestDistanceFromOrigin(String s) {
//         String s1 = new String();
//         String s2 = new String();
//         int n = s.length();

//         for(int i=0; i<n; i++){
//             if(s.charAt(i) == '_'){
//                 s1 += 'L';
//                 s2 += 'R';
//             }
//             else{
//                 s1 += s.charAt(i);
//                 s2 += s.charAt(i);
//             }
//         }
//         int max = 0;
//         int count1 = 0;
//         int count2 = 0;

//         for(int i=0; i<n; i++){
//             if(s1.charAt(i) != 'L'){
//                 if(count1 > max){
//                     max = count1;
//                 }
//                 count1 = 0;
//             }
//             else{
//                 count1++;
//             }

//             if(s2.charAt(i) != 'R'){
//                 if(count2 > max){
//                     max = count2;
//                 }
//                 count2 = 0;
//             }
//             else{
//                 count2++;
//             }

//             if(count2 > max){
//                     max = count2;
//                 }
//             if(count1 > max){
//                     max = count1;
//                 }
//         }
//         return max;
//     }
// }
