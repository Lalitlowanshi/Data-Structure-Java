class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        long k = (long) k1+k2;

        long[] diff = new long[n];
        long maxDiff = 0;
        long sum = 0;

        for(int i=0; i<n; i++){
            diff[i] = Math.abs(nums1[i] -nums2[i]);
            maxDiff = Math.max(maxDiff, diff[i]);
            sum += diff[i];
        }
        if(k >= sum){
            return 0L;
        }
        long left = 0, right = maxDiff;

        while(left < right){
            long mid = left + (right - left) / 2;
            long required = 0;

            for(long d : diff){
                if(d > mid){
                    required += d-mid;
                }
            }
            if(required <= k){
                right = mid;
            }
            else{
                left = mid+1;
            }
        }
        long level = left;
        long used = 0;

        for(int i=0; i<n; i++){
            if(diff[i] > level){
                used += diff[i] -level;
                diff[i] = level;
            }
        }

        long remaining = k-used;

        for(int i=0; i<n && remaining > 0; i++){
            if(diff[i] == level && level > 0){
                diff[i]--;
                remaining--;
            }
        }
        long ans = 0;

        for(long d : diff){
            ans += d*d;
        }
        return ans;
    }
}
