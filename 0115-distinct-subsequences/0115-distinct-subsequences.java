class Solution {
    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length()][t.length()];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return solve(dp,s,t,0,0);
    }
    int solve(int[][] dp,String s,String t,int row,int col){
        if (col == t.length()){
            return 1;
        }
        if(row ==  s.length()){
            return 0;
        }
        if(dp[row][col] != -1){
            return dp[row][col];
        }
        if(s.charAt(row) == t.charAt(col)){
            return dp[row][col] = solve(dp,s,t,row+1,col+1) + solve(dp,s,t,row+1,col);
        }
        return dp[row][col] = solve(dp,s,t,row+1,col);
        
    
    }
}