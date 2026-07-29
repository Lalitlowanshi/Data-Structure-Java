import java.math.BigInteger;

class Solution {
    public String smallestPalindrome(String s, int k) {
        int[] freq = new int[26];
        for (char ch : s.toCharArray()) freq[ch - 'a']++;

        int[] half = new int[26];
        String mid = "";
        int len = 0;

        for (int i = 0; i < 26; i++) {
            half[i] = freq[i] / 2;
            len += half[i];
            if ((freq[i] & 1) == 1) mid = String.valueOf((char) ('a' + i));
        }

        BigInteger totalWays = multinomial(half, len);

        if (totalWays.compareTo(BigInteger.valueOf(k)) < 0) return "";

        StringBuilder left = new StringBuilder();
        BigInteger K = BigInteger.valueOf(k);

        while (len > 0) {
            for (int c = 0; c < 26; c++) {
                if (half[c] == 0) continue;

                BigInteger waysWithThis =
                        totalWays.multiply(BigInteger.valueOf(half[c]))
                                 .divide(BigInteger.valueOf(len));

                if (waysWithThis.compareTo(K) >= 0) {
                    left.append((char) ('a' + c));
                    half[c]--;
                    totalWays = waysWithThis;
                    len--;
                    break;
                } else {
                    K = K.subtract(waysWithThis);
                }
            }
        }

        StringBuilder ans = new StringBuilder(left);
        ans.append(mid);
        ans.append(left.reverse());

        return ans.toString();
    }

    private BigInteger multinomial(int[] cnt, int total) {
        BigInteger res = BigInteger.ONE;
        int used = 0;

        for (int x : cnt) {
            if (x == 0) continue;
            res = res.multiply(binom(used + x, x));
            used += x;
        }

        return res;
    }

    private BigInteger binom(int n, int r) {
        r = Math.min(r, n - r);
        BigInteger res = BigInteger.ONE;

        for (int i = 1; i <= r; i++) {
            res = res.multiply(BigInteger.valueOf(n - r + i));
            res = res.divide(BigInteger.valueOf(i));
        }

        return res;
    }
}
