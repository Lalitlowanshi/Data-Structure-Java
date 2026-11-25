
class Solution {

    static final long BASE = 233;
    static final long MOD1 = 1_000_000_007;
    static final long MOD2 = 1_000_000_009;

    long[] h1, h2, p1, p2;

    public int smallestUniqueSubarray(int[] nums) {

        int n = nums.length;

        h1 = new long[n + 1];
        h2 = new long[n + 1];
        p1 = new long[n + 1];
        p2 = new long[n + 1];

        p1[0] = 1;
        p2[0] = 1;

        for (int i = 1; i <= n; i++) {

            h1[i] = (h1[i - 1] * BASE + nums[i - 1]) % MOD1;
            h2[i] = (h2[i - 1] * BASE + nums[i - 1]) % MOD2;

            p1[i] = (p1[i - 1] * BASE) % MOD1;
            p2[i] = (p2[i - 1] * BASE) % MOD2;
        }

        int low = 1, high = n;
        int ans = n;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (check(nums, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    long getHash(int l, int r) {

        int len = r - l;

        long hash1 = (h1[r] - h1[l] * p1[len] % MOD1 + MOD1) % MOD1;
        long hash2 = (h2[r] - h2[l] * p2[len] % MOD2 + MOD2) % MOD2;

        return hash1 * MOD2 + hash2;
    }

    boolean check(int[] nums, int len) {

        Map<Long, Integer> map = new HashMap<>();

        for (int i = 0; i + len <= nums.length; i++) {

            long hash = getHash(i, i + len);

            map.put(hash, map.getOrDefault(hash, 0) + 1);
        }

        for (int count : map.values()) {
            if (count == 1) {
                return true;
            }
        }

        return false;
    }
}
