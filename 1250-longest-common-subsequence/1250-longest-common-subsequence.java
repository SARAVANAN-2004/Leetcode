class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n  = text1.length(), m = text2.length();
        int[][]dp = new int[n+1][m+1];
        int maxi = 0;
        for(int i = 1;i<n+1;i++){
            for(int j = 1;j<m+1;j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j-1],Math.max(dp[i-1][j],dp[i][j-1]));
                }
                maxi = Math.max(dp[i][j],maxi);
            }
        }
        return maxi;
    }
}