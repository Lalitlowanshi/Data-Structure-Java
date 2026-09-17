class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;

        int [] best = new int[n+1];

        Arrays.fill(best, Integer.MAX_VALUE);

        Map<Integer, Integer> map = new HashMap<>();

        map.put(0,0);

        int prefixSum = 0;

        int ans = Integer.MAX_VALUE;

        for(int i=1; i<=n; i++){

            prefixSum += arr[i-1];

            best[i] = best[i-1];

            int required = prefixSum - target;

            if(map.containsKey(required)){
                int start = map.get(required);
                int length = i-start;

                if(best[start] != Integer.MAX_VALUE){
                    ans = Math.min(ans, best[start] + length);
                }
                best[i] = Math.min(best[i], length);
            }
            map.put(prefixSum, i);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
