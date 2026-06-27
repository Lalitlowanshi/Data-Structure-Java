class Solution {
    public int maximumLength(int[] nums) {
        Map<Long, Integer> freq = new HashMap<>();

        for (int x : nums) {
            freq.put((long) x,
                    freq.getOrDefault((long) x, 0) + 1);
        }

        int ans = 1;

        for (long x : freq.keySet()) {
            if (x == 1) {
                int cnt = freq.get(1L);
                if (cnt % 2 == 0) cnt--;
                ans = Math.max(ans, cnt);
                continue;
            }

            long cur = x;
            int len = 0;

            while (true) {
                int cnt = freq.getOrDefault(cur, 0);

                if (cnt >= 2) {
                    len += 2;
                } else if (cnt == 1) {
                    len++;
                    break;
                } else {
                    if (len > 0) len--;
                    break;
                }

                if (cur > Long.MAX_VALUE / cur) {
                    len--;
                    break;
                }

                cur *= cur;
            }

            ans = Math.max(ans, len);
        }

        return ans;
    }
}
