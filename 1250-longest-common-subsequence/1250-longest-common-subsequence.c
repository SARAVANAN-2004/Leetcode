int longestCommonSubsequence(char* s1, char* s2) {
    int n1 = strlen(s1);
    int n2 = strlen(s2);
    int dp[n1+1][n2+1];
    for(int i = 0;i < n1+1;i++){
        for(int j = 0;j < n2+1;j++){
            if( i == 0 || j == 0){
                dp[i][j] = 0;
            }else{
                if(s1[i-1] == s2[j-1]){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{
                    dp[i][j] = max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
    }
    return dp[n1][n2];
}
int max(int a,int b){
    return  a>=b ? a: b;
}