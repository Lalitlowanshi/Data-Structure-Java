
class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {

        int n = nums.size();
        int i = 0, j = 0, sum = 0;
        int min = Integer.MAX_VALUE;

        while (i + l <= n) {

            sum = 0;
            j = i + l;

            for (int k = i; k < i + l; k++) {
                sum += nums.get(k);
            }

            if (sum > 0 && sum < min) {
                min = sum;
            }

            while (j < i + r && j < n) {

                sum += nums.get(j);

                if (sum > 0 && sum < min) {
                    min = sum;
                }

                j++;
            }

            i++;
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
