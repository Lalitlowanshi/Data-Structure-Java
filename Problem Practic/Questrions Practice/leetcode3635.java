import java.util.*;

class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration,
                                  int[] waterStartTime, int[] waterDuration) {

        long ans = Long.MAX_VALUE;

        RideInfo waterInfo = build(waterStartTime, waterDuration);
        for (int i = 0; i < landStartTime.length; i++) {
            long finishLand = (long) landStartTime[i] + landDuration[i];
            ans = Math.min(ans, query(waterInfo, finishLand));
        }

        RideInfo landInfo = build(landStartTime, landDuration);
        for (int i = 0; i < waterStartTime.length; i++) {
            long finishWater = (long) waterStartTime[i] + waterDuration[i];
            ans = Math.min(ans, query(landInfo, finishWater));
        }

        return (int) ans;
    }

    static class RideInfo {
        int[] starts;
        long[] prefixMinDuration;
        long[] suffixMinOpenPlusDuration;

        RideInfo(int[] starts, long[] prefixMinDuration,
                 long[] suffixMinOpenPlusDuration) {
            this.starts = starts;
            this.prefixMinDuration = prefixMinDuration;
            this.suffixMinOpenPlusDuration = suffixMinOpenPlusDuration;
        }
    }

    private RideInfo build(int[] start, int[] duration) {
        int n = start.length;

        int[][] rides = new int[n][2];
        for (int i = 0; i < n; i++) {
            rides[i][0] = start[i];
            rides[i][1] = duration[i];
        }

        Arrays.sort(rides, Comparator.comparingInt(a -> a[0]));

        int[] starts = new int[n];
        long[] prefixMinDuration = new long[n];
        long[] suffixMinOpenPlusDuration = new long[n];

        for (int i = 0; i < n; i++) {
            starts[i] = rides[i][0];
        }

        long minDur = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            minDur = Math.min(minDur, rides[i][1]);
            prefixMinDuration[i] = minDur;
        }

        long minOpenPlusDur = Long.MAX_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            minOpenPlusDur = Math.min(
                minOpenPlusDur,
                (long) rides[i][0] + rides[i][1]
            );
            suffixMinOpenPlusDuration[i] = minOpenPlusDur;
        }

        return new RideInfo(starts, prefixMinDuration, suffixMinOpenPlusDuration);
    }

    private long query(RideInfo info, long t) {
        int idx = upperBound(info.starts, (int) t) - 1;

        long res = Long.MAX_VALUE;

        if (idx >= 0) {
            res = Math.min(res, t + info.prefixMinDuration[idx]);
        }

        if (idx + 1 < info.starts.length) {
            res = Math.min(res, info.suffixMinOpenPlusDuration[idx + 1]);
        }

        return res;
    }

    private int upperBound(int[] arr, int target) {
        int l = 0, r = arr.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] <= target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}
