class Solution {
    class BIT {
        int[] tree;
        int n;

        BIT(int n) {
            this.n = n;
            tree = new int[n + 2];
        }

        void update(int i, int val) {
            while (i <= n) {
                tree[i] += val;
                i += i & -i;
            }
        }

        int query(int i) {
            int sum = 0;
            while (i > 0) {
                sum += tree[i];
                i -= i & -i;
            }
            return sum;
        }
    }

    public long countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;

        int offset = n + 1;
        BIT bit = new BIT(2 * n + 5);

        long ans = 0;
        int pref = 0;

        // prefix sum 0 already exists
        bit.update(offset, 1);

        for (int x : nums) {
            if (x == target)
                pref += 1;
            else
                pref -= 1;

            int idx = pref + offset;

            // count previous prefix sums < current prefix
            ans += bit.query(idx - 1);

            bit.update(idx, 1);
        }

        return ans;
    }
}
