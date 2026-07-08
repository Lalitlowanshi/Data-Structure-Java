class Solution {
    static final long MOD = 1_000_000_007L;

    public int[] sumAndMultiply(String s, int[][] queries) {

        int n = s.length();

        // prefix sum of non-zero digits
        int[] prefSum = new int[n + 1];

        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> digits = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int d = s.charAt(i) - '0';

            prefSum[i + 1] = prefSum[i];

            if (d != 0) {
                prefSum[i + 1] += d;
                pos.add(i);
                digits.add(d);
            }
        }

        int k = digits.size();

        long[] pow10 = new long[k + 1];
        pow10[0] = 1;

        for (int i = 1; i <= k; i++)
            pow10[i] = (pow10[i - 1] * 10) % MOD;

        long[] prefConcat = new long[k + 1];

        for (int i = 0; i < k; i++) {
            prefConcat[i + 1] = (prefConcat[i] * 10 + digits.get(i)) % MOD;
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            int l = queries[i][0];
            int r = queries[i][1];

            int left = lowerBound(pos, l);
            int right = upperBound(pos, r) - 1;

            if (left > right) {
                ans[i] = 0;
                continue;
            }

            long sum = prefSum[r + 1] - prefSum[l];

            int len = right - left + 1;

            long x = (prefConcat[right + 1]
                    - prefConcat[left] * pow10[len]) % MOD;

            if (x < 0)
                x += MOD;

            ans[i] = (int) ((x * sum) % MOD);
        }

        return ans;
    }

    int lowerBound(ArrayList<Integer> arr, int target) {
        int l = 0, r = arr.size();

        while (l < r) {
            int m = (l + r) / 2;

            if (arr.get(m) >= target)
                r = m;
            else
                l = m + 1;
        }

        return l;
    }

    int upperBound(ArrayList<Integer> arr, int target) {
        int l = 0, r = arr.size();

        while (l < r) {
            int m = (l + r) / 2;

            if (arr.get(m) > target)
                r = m;
            else
                l = m + 1;
        }

        return l;
    }
}






// Time Limit Exceeded
// 508 / 523 testcases passed


// class Solution {
//     public int[] sumAndMultiply(String s, int[][] queries) {
//         int n = s.length();
//         int m = queries.length;
//         int [] ans = new int[m];
//         long MOD = 1000000007;

//         for(int i=0; i<m; i++){
//             long conc = 0;
//             long sum = 0;
//             for(int j=queries[i][0]; j<=queries[i][1]; j++){
//                 int digit = s.charAt(j) - '0';
//                 if(digit > 0){
//                     conc = (conc * 10 + digit) % MOD;
//                     sum += digit;
//                 }
//             }
//             ans[i] = (int)((conc*sum) % MOD);
//         }
//         return ans;
//     }
// }
