class Solution {
    int[] adjRow = new int[]{-1,0,1};
    public int maxMoves(int[][] grid) {
        int row = grid.length;
        int  col= grid[0].length;
        int[][] dp = new int[row][col];
        // for(int r= 0;r<row;r++){
        //     dp[r][col-1] = 1;
        // }
        for(int c = col-2 ; c>=0;c--){
            for(int r = 0;r<row;r++){
                int nextMove = solve(r,c,grid[r][c],row,col,grid,dp);
                if(nextMove != -1){
                    dp[r][c] = nextMove+1;
                }
            }
        }
        int max = 0;
        for(int[] i : dp){
            max = Math.max(i[0],max);
        }
        return max;
        
    }

    public int solve(int curRow,int curCol,int val,int m,int n,int[][] grid,int[][] dp){
        int max = -1;
        for(int i:adjRow){
            int nextRow = curRow+i;
            int nextCol = curCol +1;
            if(nextRow >= 0 && nextRow <m && val < grid[nextRow][nextCol]){
                max = Math.max(max,dp[nextRow][nextCol]);
            }
        }

        return max;
    }
}