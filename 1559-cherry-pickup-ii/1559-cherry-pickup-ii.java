class Solution {
    int[][][] dp;
    public int cherryPickup(int[][] grid) {
        int n = grid.length,m = grid[0].length;
        dp = new int[n][m][m];

        for(int i[][] :dp){
            for(int j[]:i){
                Arrays.fill(j,-1);
                
            }
        }
        

        return solve(0,0,m-1,n,m,grid);
    }
    int solve(int r,int c1,int  c2,int n,int m,int[][] grid){
        if(c1 < 0 || c1 >= m || c2 < 0 || c2 >= m){
            return 0;
        }
        if(dp[r][c1][c2] != -1) return dp[r][c1][c2];
        int value = grid[r][c1];
        if(c1 != c2){
            value = grid[r][c1] + grid[r][c2];
        } 
        if(r == n-1){
            dp[r][c1][c2] = value;
            return value;
        }
        int maxi = 0;
        for(int dj1 = -1; dj1 <= 1;dj1++){
            for(int dj2 = -1;dj2 <= 1;dj2++){
                maxi = Math.max(maxi,value+solve(r+1,c1+dj1,c2+dj2,n,m,grid));
            }
        }

        return dp[r][c1][c2] = maxi;

    }
}