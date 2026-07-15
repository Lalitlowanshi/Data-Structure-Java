class Solution {
    public int gcdOfOddEvenSums(int n) {
        return n;
    }
}

// Logical Solution...

// class Solution {
//     public int gcdOfOddEvenSums(int n) {
//         int odd = n * n;
//         int even = n * (n + 1);
//         return gcd(odd, even);
//     }

//     private int gcd(int a, int b) {
//         while (b != 0) {
//             int t = b;
//             b = a % b;
//             a = t;
//         }
//         return a;
//     }
// }


// Brute Force Solution...

// class Solution {
//     public int gcdOfOddEvenSums(int n) {
//         int odd = n*n;
//         int even = n*(n+1);

//         for(int i=odd; i>0; i--){
//             if(even%i == 0 && odd%i == 0){
//                 return i;
//             }
//         }
//         return 1;
//     }
// }
