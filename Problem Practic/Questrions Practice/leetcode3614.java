class Solution {
    public char processStr(String s, long k) {
        int n = s.length();
        long[] len = new long[n + 1];
        long LIMIT = (long) 1e15 + 5;

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            long cur = len[i];

            if (c >= 'a' && c <= 'z') {
                len[i + 1] = Math.min(LIMIT, cur + 1);
            } else if (c == '*') {
                len[i + 1] = Math.max(0, cur - 1);
            } else if (c == '#') {
                len[i + 1] = Math.min(LIMIT, cur * 2);
            } else { // '%'
                len[i + 1] = cur;
            }
        }

        if (k < 0 || k >= len[n]) {
            return '.';
        }

        for (int i = n - 1; i >= 0; i--) {
            char c = s.charAt(i);
            long prevLen = len[i];

            if (c >= 'a' && c <= 'z') {
                if (k == prevLen) {
                    return c;
                }
            } else if (c == '#') {
                if (prevLen > 0) {
                    k %= prevLen;
                }
            } else if (c == '%') {
                if (prevLen > 0) {
                    k = prevLen - 1 - k;
                }
            }
            // '*' needs no change: indices < new length remain unchanged
        }

        return '.';
    }
}
