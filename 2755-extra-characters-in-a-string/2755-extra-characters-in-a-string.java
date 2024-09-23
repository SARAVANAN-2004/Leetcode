class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        Set<String> set = new HashSet<>(Arrays.asList(dictionary));
        int n = s.length();
        Integer[] dp = new Integer[n];
        return dfs(s,set,0,dp);
    }
    public int dfs(String s,Set<String> set,int start,Integer[] dp){
        if(start == s.length()){
            return 0;
        }
        if(dp[start] != null){
            return dp[start];
        }

        int res = 1 + dfs(s,set,start+1,dp);
        for(int i = start;i<s.length();i++){
            if(set.contains(s.substring(start,i+1))){
                res = Math.min(res,dfs(s,set,i+1,dp));
            }
        }
        dp[start] = res;
        return res;
    }
}