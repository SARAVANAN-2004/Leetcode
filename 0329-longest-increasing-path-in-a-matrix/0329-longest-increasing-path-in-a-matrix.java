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
                max = Math.max(max,dfs(matrix,dp,row,col,r,c,-1));
            }
        }
        
        // for(int r = 0;r < row;r++){
        //     for(int c = 0;c <col;c++){
        //         System.out.print(dp[r][c]+" ");
                
        //     }
        //     System.out.println();
        // }
        return max;
    }
    int  dfs(int[][] matrix,int [][] dp,int row,int col,int r,int c,int prev){
        if(r < 0 || r >= row || c < 0 || c>= col){
            return 0 ;
        }
        if(matrix[r][c] <= prev){
            return 0;
        }
        if(dp[r][c] != -1){
            return dp[r][c];
        }

        int left = dfs(matrix,dp,row,col,r,c+1,matrix[r][c]);
        int right = dfs(matrix,dp,row,col,r,c-1,matrix[r][c]);
        int top = dfs(matrix,dp,row,col,r+1,c,matrix[r][c]);
        int down = dfs(matrix,dp,row,col,r-1,c,matrix[r][c]);
        dp[r][c] = Math.max(Math.max(left,right),Math.max(top,down)) + 1;
        return dp[r][c];

    }
}