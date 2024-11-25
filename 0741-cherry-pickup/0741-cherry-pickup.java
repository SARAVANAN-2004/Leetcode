class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int dp[][][] = new int[n][n][n];
        for(int m[][] :dp){
            for(int[] row:m){
                Arrays.fill(row,-1);
            }
        }

        int cherries = pick(grid,dp,n,0,0,0);
        return Math.max(0,cherries);
    }

    private int pick(int[][] grid,int[][][] dp,int n, int r1,int c1,int r2){
        int c2 = r1+c1-r2;
        if(r1 >= n || c1 >= n || r2 >= n || c2 < 0||c2 >= n || grid[r1][c1] == -1 || grid[r2][c2] == -1){
            return Integer.MIN_VALUE;
        }
        if(dp[r1][c1][r2] != -1){
            return dp[r1][c1][r2];
        }
        if(r1 == n-1 && c1 == n-1){
            return grid[r1][c1];
        }
        int cherries = grid[r1][c1];
        if(r1 != r2 && c1 != c2){
            cherries += grid[r2][c2];
        }
        //rr
        int rr =  pick(grid,dp,n,r1,c1+1,r2);
        int rd = pick(grid,dp,n,r1,c1+1,r2+1);
        int dd = pick(grid,dp,n,r1+1,c1,r2+1);
        int dr = pick(grid,dp,n,r1+1,c1,r2);

        dp[r1][c1][r2] = cherries+Math.max(Math.max(rr,rd),Math.max(dd,dr));
        

        return dp[r1][c1][r2];


    }
} 