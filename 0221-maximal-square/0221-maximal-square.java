class Solution {
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length , m = matrix[0].length;
       
        int[][] dp = new int[n][m];
        int maxi = 0;
        for(int i = 0;i<n;i++){
            dp[i][0] = (int)(matrix[i][0] -'0');
            maxi  = Math.max(maxi,dp[i][0]);
        }
        for(int i = 0;i<m;i++){
            dp[0][i] =(int)(matrix[0][i] - '0');
            maxi  = Math.max(maxi,dp[0][i]);
        }
        // if(n == 1 || m == 1) return maxi;
        for(int r = 1;r<n;r++){
            for(int c = 1;c<m;c++){
                if(matrix[r][c] == '1'){
                    dp[r][c] = Math.min(dp[r-1][c-1],Math.min(dp[r][c-1],
                    dp[r-1][c]))+1;
                    maxi = Math.max(dp[r][c],maxi);
                }
            }
        }
        
        return maxi * maxi;
    }
}