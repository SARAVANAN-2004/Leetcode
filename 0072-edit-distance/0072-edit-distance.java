class Solution {
    public int minDistance(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n+1][m+1];
        // if(n == 0 || m == 0) return n == 0? m : n;
        for(int r = 0;r<=n;r++){
            dp[r][0] = r;
        }
        for(int c = 0;c<=m;c++){
            dp[0][c] = c;
        }

        for(int r = 1;r<=n;r++){
            for(int c = 1;c<=m;c++){
                if(s1.charAt(r-1) == s2.charAt(c-1)){
                    dp[r][c] = dp[r-1][c-1];
                }else{
                    dp[r][c] = Math.min(dp[r-1][c-1],Math.min(dp[r][c-1],dp[r-1][c]))+1;
                }
            }
        }
        return dp[n][m];
    }
}