class Solution {
    public long gcdSum(int[] nums) {
        int n = nums.length;
        int max = nums[0];
        int [] prefixGcd = new int [n];
        long ans = 0;

        for(int i=0; i<n; i++){
            if(nums[i] > max){
                max = nums[i];
            }
            prefixGcd[i] = gcd(max, nums[i]);
        }
        Arrays.sort(prefixGcd);

        int i = 0;
        int j = n-1;
        while (i < j){
            ans += gcd(prefixGcd[i], prefixGcd[j]);
            i++;
            j--;
        }
        return ans;
    }
    
        public int gcd(int a, int b){
            while(b != 0){
                int t = b;
                b = a%b;
                a = t;
            }
            return a;
        }
}
