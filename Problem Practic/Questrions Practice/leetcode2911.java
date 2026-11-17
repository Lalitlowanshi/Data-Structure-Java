class Solution {
    public int minimumChanges(String s, int k) {
        int n = s.length();
        int inf = 1000000;

        int [][] cost = new int[n][n];

        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                int len = j-i+1;
                cost[i][j] = inf;

                for(int d=1; d<len; d++){
                    if(len % d != 0){
                        continue;
                    }
                    int groups = len/d;
                    int changes = 0;

                    for(int r=0; r<d; r++){
                        for(int t=0; t<groups/2; t++){
                            int left = i+r+t*d;
                            int right = i+r+(groups-1-t)*d;

                            if(s.charAt(left) != s.charAt(right)){
                                changes++;
                            }
                        }
                    }
                    cost[i][j] = Math.min(cost[i][j], changes);
                }
            }
        }
        int [][] dp = new int[k+1][n+1];

        for(int [] row : dp){
            java.util.Arrays.fill(row,inf);
        }
        dp[0][0] = 0;

        for(int p=1; p<=k; p++){
            for(int i=2*p; i<=n; i++){
                for(int j=2*(p-1); j<=i-2; j++){
                    if(dp[p-1][j] == inf){
                        continue;
                    }
                    dp[p][i] = Math.min(dp[p][i], dp[p-1][j] + cost[j][i-1]);
                }
            }
        }
        return dp[k][n];
    }
}
