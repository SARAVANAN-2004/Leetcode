class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        Integer[][][] dp = new Integer[2][n][n+1];
        return dfs(true,0,1,piles,dp);
    }
    private int dfs(boolean alice_turn,int i,int m,int[] piles,Integer[][][] dp){
        if(i == piles.length){
            return 0;
        }
        int player_ind = alice_turn?0:1;
        if(dp[player_ind][i][m] != null){
            return dp[player_ind][i][m];
        }
        int res;
        if (alice_turn){
            res = 0;
        }else{
            res = Integer.MAX_VALUE;
        }
        int total = 0;
        for(int x = 1;x <= 2*m;x++){
            if(i+x > piles.length){
                break;
            }
            total += piles[i+x-1];
            if (alice_turn){
                res = Math.max(res,total + dfs(!alice_turn,i+x,Math.max(m,x),piles,dp));
            }
            else{
                res = Math.min(res, dfs(!alice_turn,i+x,Math.max(m,x),piles,dp));
            }
        }
        dp[player_ind][i][m] = res;
        return res;
    }
}