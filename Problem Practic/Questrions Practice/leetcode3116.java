class Solution {
    public long findKthSmallest(int[] coins, int k) {
        int n = coins.length;

        long low = 1;
        long high = (long) k * coins[0];

        for (int c : coins) {
            high = Math.min(high, (long) k * c);
        }

        while (low < high) {
            long mid = low + (high - low) / 2;

            if (count(mid, coins, n) >= k)
                high = mid;
            else
                low = mid + 1;
        }

        return low;
    }

    private long count(long x, int[] coins, int n) {
        long ans = 0;

        for (int mask = 1; mask < (1 << n); mask++) {
            long lcm = 1;
            int bits = 0;

            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    bits++;

                    lcm = lcm(lcm, coins[i]);

                    if (lcm > x)
                        break;
                }
            }

            if (bits % 2 == 1)
                ans += x / lcm;
            else
                ans -= x / lcm;
        }

        return ans;
    }

    private long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}
