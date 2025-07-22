class Solution {
    int[][] dp;
    int[][] adj = new int[][]{
        {1,0},{-1,0},{0,1},{0,-1}
    };
    int row,col;
    public int longestIncreasingPath(int[][] matrix) {
        row = matrix.length ;
        col = matrix[0].length;
        dp = new int[row][col];
        for(int[] i :dp) Arrays.fill(i,-1);
        int maxi  = 1;
        for(int r = 0;r<row;r++){
            for(int c = 0;c<col;c++){
                if(dp[r][c] == -1){
                    dfs(r,c,matrix);
                }
                maxi = Math.max(maxi,dp[r][c]);
            }
            // System.out.println(Arrays.toString(dp[r]));
        }
        return maxi;
    }

    public int  dfs(int r,int c,int[][] matrix){
        if(dp[r][c] != -1){
            return dp[r][c];
        }
        int maxi = 0;
        for(int i = 0;i<4;i++){
            int ar = r + adj[i][0], ac = c + adj[i][1];
            if(ar >= 0 && ar < row && ac >= 0 && ac < col && matrix[ar][ac] > matrix[r][c]){
                maxi = Math.max(maxi,dfs(ar,ac,matrix));
            }
        }
        maxi++;
        // System.out.println(r+" "+c+" "+maxi);
        return dp[r][c] = maxi;
        
    }
}