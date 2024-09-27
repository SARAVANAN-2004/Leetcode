class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row][col];
        for(int[] rows:dp){
            Arrays.fill(rows,-1);
        }
        int max = 0;
        for(int r = 0;r < row;r++){
            for(int c = 0;c <col;c++){
                if(dp[r][c] == -1){
                     dp[r][c] = dfs(matrix,dp,row,col,r,c);
                }
                max = Math.max(max,dp[r][c]);
            }
        }
        
        // for(int r = 0;r < row;r++){
        //     for(int c = 0;c <col;c++){
        //         // System.out.print(dp[r][c]+" ");
                
        //     }
        //     // System.out.println();
        // }
        return max+1;
    }
    int  dfs(int[][] matrix,int [][] dp,int row,int col,int r,int c){
        if(r < 0 || r >= row || c < 0 || c>= col){
            return 0 ;
        }
        if(dp[r][c] != -1){
            return dp[r][c];
        }
        // left
        if(c+1 < col && matrix[r][c+1] > matrix[r][c]){
            dp[r][c] = Math.max(dp[r][c],dfs(matrix,dp,row,col,r,c+1));
        }
        // right
        if(c-1 >= 0 && matrix[r][c-1] > matrix[r][c]){
            dp[r][c] = Math.max(dp[r][c],dfs(matrix,dp,row,col,r,c-1));
        }
        // top 
        if(r+1 < row && matrix[r+1][c] > matrix[r][c]){
            dp[r][c] = Math.max(dp[r][c],dfs(matrix,dp,row,col,r+1,c));
        }
        // down
        if(r-1 >= 0 && matrix[r-1][c] > matrix[r][c]){
            dp[r][c] = Math.max(dp[r][c],dfs(matrix,dp,row,col,r-1,c));
        }
        return ++dp[r][c];

    }
}