class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[n] = true;
        for(int st = n-1;st>=0;st--){
            for(String word:wordDict){
                int m = word.length();
                if(st + m<= n && 
                s.substring(st,st+m).equals(word)){
                    dp[st] = dp[st+m];
                }
                if(dp[st]){
                    break;
                }
            }
        }
        return dp[0];
    }
    
}