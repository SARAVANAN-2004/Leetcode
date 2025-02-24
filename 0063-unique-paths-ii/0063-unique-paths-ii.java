class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        if(grid[0][0] == 1 || grid[n-1][m-1] == 1) return 0;
        dp[0][0] = grid[0][0] == 0 ? 1: 0;
        for(int c = 1;c<m;c++){
            dp[0][c] = grid[0][c] == 0 ? dp[0][c-1] : 0;
        }for(int r = 1;r<n;r++){
            dp[r][0] = grid[r][0] == 0?dp[r-1][0] : 0;
        }
        for(int r = 1;r<n;r++){
            for(int c= 1;c<m;c++){
                if(grid[r][c] == 0){
                    dp[r][c] = dp[r-1][c] + dp[r][c-1];
                }
            }
        }
        // for(int r = 0;r<n;r++){
        //     System.out.println(Arrays.toString(dp[r]));
        // }
        return dp[n-1][m-1];
    }
}