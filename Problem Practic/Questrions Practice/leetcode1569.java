class Solution {
    static final int mod = 1000000007;
    long [][] comb;

    public int numOfWays(int[] nums) {
        int n = nums.length;
        comb = new long[n+1][n+1];

        for(int i=0; i<=n; i++){
            comb[i][0] = comb[i][i] = 1;

            for(int j=1; j<i; j++){
                comb[i][j] = (comb[i-1][j-1] + comb[i-1][j]) % mod;
            }
        }
        long ans = solve(nums);
        return  (int)((ans-1+mod)%mod);
    }

    private long solve(java.util.List<Integer> nums){
        int n = nums.size();

        if(n <= 2){
            return 1;
        }
        
        int root = nums.get(0);

        java.util.List<Integer> left = new java.util.ArrayList<>();
        java.util.List<Integer> right = new java.util.ArrayList<>();

        for(int i=1; i<n; i++){
            int val = nums.get(i);

            if(val < root){
                left.add(val);
            }
            else{
                right.add(val);
            }
        }
        long leftWays = solve(left);
        long rightWays = solve(right);

        long ways = comb[n-1][left.size()];
        ways = ways * leftWays % mod;
        ways = ways * rightWays % mod;

        return ways;
    }

    private long solve(int[] nums){
        java.util.List<Integer> list = new java.util.ArrayList<>();

        for(int num : nums){
            list.add(num);
        }
        return solve(list);
    }
}
