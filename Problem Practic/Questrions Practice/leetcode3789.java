class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {

        long a = (long) need1 * cost1 + (long) need2 * cost2;

        long b = (long) costBoth * Math.max(need1, need2);

        int minNeed = Math.min(need1, need2);

        long c = (long) costBoth * minNeed
               + (long) (need1 - minNeed) * cost1
               + (long) (need2 - minNeed) * cost2;

        return Math.min(a, Math.min(b, c));
    }
}
