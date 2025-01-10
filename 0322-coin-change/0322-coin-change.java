class Solution {
    public int coinChange(int[] coins, int amount) {
        int row = coins.length;
        int[][] dp = new int[row][amount+1];
        Arrays.sort(coins);
        for(int r = 0;r<row;r++){
            int cur = coins[r];
            for(int am = 1;am < amount+1;am++){
                if(am < cur){
                    if(r == 0){
                        dp[r][am] = Integer.MAX_VALUE;
                    }else{
                        dp[r][am] = dp[r-1][am];
                    }
                }else{
                    if(dp[r][am-cur] == Integer.MAX_VALUE){
                        dp[r][am] = Integer.MAX_VALUE;
                        
                    }else{
                    dp[r][am] = dp[r][am-cur]+1;
                    }
                    if(r > 0){
                        dp[r][am] = Math.min(dp[r][am],dp[r-1][am]);
                    }
                }
            }
        }
        
        return dp[row-1][amount] == Integer.MAX_VALUE ? -1 : dp[row-1][amount];

        
    }
}