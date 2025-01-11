class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        for(int i = 0;i<n-1;i++){
            if(ratings[i] < ratings[i+1]){
                dp[i+1] = Math.max(dp[i+1],dp[i]+1);
            }
        }
        for(int i = n-1;i>0;i--){
            if(ratings[i] < ratings[i-1]){
                dp[i-1] = Math.max(dp[i-1],dp[i]+1);
            }
        }

        return Arrays.stream(dp).sum();
    }
}