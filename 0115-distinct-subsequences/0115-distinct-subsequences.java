class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length() , m = t.length();
        int[][] dp = new int[n+1][m+1];
        for(int i[]:dp){
            Arrays.fill(i,-1);
        }
        return func(n-1,m-1,s,t,dp);
    }
    int func(int i,int j,String s,String t,int[][] dp){
        if(j < 0) return 1;

        if(i < 0) return 0;
        if(dp[i][j] != -1) return dp[i][j];

        if(s.charAt(i) == t.charAt(j)){
            return dp[i][j] = func(i-1,j-1,s,t,dp) + func(i-1,j,s,t,dp);
        }
        return dp[i][j] =  func(i-1,j,s,t, dp);
    }

}