import java.util.*;

class Group {
    int start;
    int length;

    Group(int start, int length) {
        this.start = start;
        this.length = length;
    }
}

class SparseTable {
    int n;
    int[][] st;

    SparseTable(int[] nums) {
        n = nums.length;
        int lg = bitLength(Math.max(1, n));
        st = new int[lg + 1][Math.max(1, n)];

        for (int i = 0; i < n; i++)
            st[0][i] = nums[i];

        for (int k = 1; k <= lg; k++) {
            for (int i = 0; i + (1 << k) <= n; i++) {
                st[k][i] = Math.max(st[k - 1][i],
                        st[k - 1][i + (1 << (k - 1))]);
            }
        }
    }

    int query(int l, int r) {
        if (l > r) return 0;
        int k = bitLength(r - l + 1) - 1;
        return Math.max(st[k][l], st[k][r - (1 << k) + 1]);
    }

    int bitLength(int x) {
        return 32 - Integer.numberOfLeadingZeros(x);
    }
}

class Solution {

    public List<Integer> maxActiveSectionsAfterTrade(String s, int[][] queries) {

        int ones = 0;
        for (char c : s.toCharArray())
            if (c == '1') ones++;

        Object[] info = getZeroGroups(s);
        @SuppressWarnings("unchecked")
        List<Group> zeroGroups = (List<Group>) info[0];
        int[] zeroGroupIndex = (int[]) info[1];

        List<Integer> ans = new ArrayList<>();

        if (zeroGroups.isEmpty()) {
            for (int i = 0; i < queries.length; i++)
                ans.add(ones);
            return ans;
        }

        SparseTable st = new SparseTable(getZeroMergeLengths(zeroGroups));

        for (int[] q : queries) {
            int l = q[0];
            int r = q[1];

            int left = -1;
            if (zeroGroupIndex[l] != -1) {
                Group g = zeroGroups.get(zeroGroupIndex[l]);
                left = g.length - (l - g.start);
            }

            int right = -1;
            if (zeroGroupIndex[r] != -1) {
                Group g = zeroGroups.get(zeroGroupIndex[r]);
                right = r - g.start + 1;
            }

            int[] p = mapToAdjacentGroupIndices(
                    zeroGroupIndex[l] + 1,
                    s.charAt(r) == '1'
                            ? zeroGroupIndex[r]
                            : zeroGroupIndex[r] - 1);

            int startAdj = p[0];
            int endAdj = p[1];

            int best = ones;

            if (s.charAt(l) == '0'
                    && s.charAt(r) == '0'
                    && zeroGroupIndex[l] + 1 == zeroGroupIndex[r]) {

                best = Math.max(best, ones + left + right);

            } else if (startAdj <= endAdj) {

                best = Math.max(best,
                        ones + st.query(startAdj, endAdj));
            }

            if (s.charAt(l) == '0'
                    && zeroGroupIndex[l] + 1 <=
                    (s.charAt(r) == '1'
                            ? zeroGroupIndex[r]
                            : zeroGroupIndex[r] - 1)) {

                best = Math.max(best,
                        ones + left +
                                zeroGroups.get(zeroGroupIndex[l] + 1).length);
            }

            if (s.charAt(r) == '0'
                    && zeroGroupIndex[l] < zeroGroupIndex[r] - 1) {

                best = Math.max(best,
                        ones + right +
                                zeroGroups.get(zeroGroupIndex[r] - 1).length);
            }

            ans.add(best);
        }

        return ans;
    }

    private Object[] getZeroGroups(String s) {

        List<Group> groups = new ArrayList<>();
        int[] idx = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                if (i > 0 && s.charAt(i - 1) == '0')
                    groups.get(groups.size() - 1).length++;
                else
                    groups.add(new Group(i, 1));
            }
            idx[i] = groups.size() - 1;
        }

        return new Object[]{groups, idx};
    }

    private int[] getZeroMergeLengths(List<Group> groups) {

        int[] res = new int[Math.max(0, groups.size() - 1)];

        for (int i = 0; i + 1 < groups.size(); i++)
            res[i] = groups.get(i).length + groups.get(i + 1).length;

        return res;
    }

    private int[] mapToAdjacentGroupIndices(int start, int end) {
        return new int[]{start, end - 1};
    }
}
