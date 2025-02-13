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
        for(int r  = n-3;r>=0;r--){
            for(int c = r+2;c<n;c++){
                if(s.charAt(r) == s.charAt(c)){
                    dp[r][c] = dp[r+1][c-1];
                    if(dp[r][c]){
                        if(max < c - r+1){
                            max = c-r+1;
                            idx[0] = r;
                            idx[1] = c;
                        }
                    }
                }
            }
        }
        // for(boolean i[]:dp){
        //     System.out.println(Arrays.toString(i));
        // }
        // System.out.println(max);
        return s.substring(idx[0],idx[1]+1);
    }
}