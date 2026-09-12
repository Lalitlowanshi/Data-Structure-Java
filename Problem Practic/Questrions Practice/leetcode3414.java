import java.util.*;

class Solution {

    static class Pair {
        long score;
        List<Integer> list;

        Pair(long score, List<Integer> list) {
            this.score = score;
            this.list = list;
        }
    }

    int[][] a;
    int[] next;
    Pair[][] dp;

    public int[] maximumWeight(List<List<Integer>> intervals) {

        int n = intervals.size();

        // start, end, weight, original index
        a = new int[n][4];

        for (int i = 0; i < n; i++) {
            a[i][0] = intervals.get(i).get(0);
            a[i][1] = intervals.get(i).get(1);
            a[i][2] = intervals.get(i).get(2);
            a[i][3] = i;
        }

        // Sort by start time
        Arrays.sort(a, (x, y) -> {
            if (x[0] != y[0])
                return Integer.compare(x[0], y[0]);

            return Integer.compare(x[1], y[1]);
        });

        // Find next compatible interval
        next = new int[n];

        for (int i = 0; i < n; i++) {

            int l = i + 1;
            int r = n;

            while (l < r) {

                int mid = l + (r - l) / 2;

                if (a[mid][0] > a[i][1])
                    r = mid;
                else
                    l = mid + 1;
            }

            next[i] = l;
        }

        dp = new Pair[n + 1][5];

        Pair ans = solve(0, 4);

        int[] result = new int[ans.list.size()];

        for (int i = 0; i < ans.list.size(); i++) {
            result[i] = ans.list.get(i);
        }

        // LeetCode requires indices in sorted order
        Arrays.sort(result);

        return result;
    }

    private Pair solve(int i, int k) {

        if (i == a.length || k == 0) {
            return new Pair(0, new ArrayList<>());
        }

        if (dp[i][k] != null)
            return dp[i][k];

        // Skip current interval
        Pair skip = solve(i + 1, k);

        // Take current interval
        Pair temp = solve(next[i], k - 1);

        List<Integer> takeList = new ArrayList<>();

        takeList.add(a[i][3]);
        takeList.addAll(temp.list);

        Pair take = new Pair(
            a[i][2] + temp.score,
            takeList
        );

        dp[i][k] = better(skip, take);

        return dp[i][k];
    }

    private Pair better(Pair x, Pair y) {

        // Higher score
        if (x.score != y.score) {
            return x.score > y.score ? x : y;
        }

        // Same score -> lexicographically smaller indices
        List<Integer> xList = new ArrayList<>(x.list);
        List<Integer> yList = new ArrayList<>(y.list);

        Collections.sort(xList);
        Collections.sort(yList);

        for (int i = 0; i < Math.min(xList.size(), yList.size()); i++) {

            if (!xList.get(i).equals(yList.get(i))) {
                return xList.get(i) < yList.get(i) ? x : y;
            }
        }

        return xList.size() <= yList.size() ? x : y;
    }
}
