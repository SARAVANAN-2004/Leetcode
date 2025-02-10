class Solution {
    int[][][] dp;
    int n;
    
    public int cherryPickup(int[][] grid) {
        n = grid.length;
       
        dp = new int[n][n][n];
        for(int i[][] :dp){
            for(int j[]:i){
                Arrays.fill(j,-1);
            }
        }
        int cheries  = solve(0,0,0,grid);
        return Math.max(0,cheries);
    }
    int solve(int r1,int r2,int c1,int[][] grid){
        int c2 = r1+c1-r2;
        if(r1 >= n || r2 >= n || c1 >= n  || c2 >= n || grid[r1][c1] == -1|| grid[r2][c2] == -1){
            return Integer.MIN_VALUE;
        }

        if(dp[r1][r2][c1] != -1) return dp[r1][r2][c1];
        int cherries = grid[r1][c1];
        if(r1 == n-1 && c1 == n-1){
            return grid[r1][c1];
        }
        if(r1 != r2  && c1 != c2){
            cherries += grid[r2][c2];
        }

        int rr = solve(r1,r2,c1+1,grid);
        int rd = solve(r1,r2+1,c1+1,grid);
        int dr = solve(r1+1,r2,c1,grid);
        int dd = solve(r1+1,r2+1,c1,grid);

        return dp[r1][r2][c1] = cherries + Math.max(Math.max(rr,rd),Math.max(dr,dd));
    }
}