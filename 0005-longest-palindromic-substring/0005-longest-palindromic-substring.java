class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for(int i = 0;i<n;i++){
            dp[i][i]  = true;
        }
        int[] idx = new int[2];
        int max = 0;
        for(int i = 0;i<n-1;i++){
            if(s.charAt(i) == s.charAt(i+1)){
                dp[i][i+1] = true;
                dp[i+1][i] = true;
                max = 2;
                idx[0] = i;
                idx[1] = i+1;
             }
        }

         for (int len = 3; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) { 
                int j = i + len - 1;
                
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true; 
                    idx[0] = i;
                    idx[1] = j;
                }
            }
        }

      
        return s.substring(idx[0],idx[1]+1);
    }
}