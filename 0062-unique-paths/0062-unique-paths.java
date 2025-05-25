class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        if(n == 1 && m == 1) return 1;
        for(int i = 0;i<m;i++){
            dp[i][0]++;
        }
        for(int i = 0;i<n;i++){
            dp[0][i]++;
        }
        for(int i = 1;i<m;i++){
            for(int j = 1;j<n;j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}