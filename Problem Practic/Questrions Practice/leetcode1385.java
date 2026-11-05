class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int ans = 0;

        for(int i = 0; i < arr1.length; i++) {
            boolean flag = true;

            for(int j = 0; j < arr2.length; j++) {
                int temp = Math.abs(arr1[i] - arr2[j]);

                if(temp <= d) {
                    flag = false;
                    break;
                }
            }

            if(flag) {
                ans++;
            }
        }

        return ans;
    }
}
