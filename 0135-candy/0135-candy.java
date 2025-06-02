class Solution {
    public int candy(int[] rat) {
        int n = rat.length;
        int[] dp  = new int[n];
        Arrays.fill(dp,1);
        for(int i = 1;i<n;i++){
            if(rat[i-1] < rat[i]){
                dp[i] = dp[i-1]+1;
            }
        }
        for(int i = n-2;i>=0;i--){
            if(rat[i] > rat[i+1] && dp[i] <= dp[i+1]){
                dp[i] = Math.max(dp[i],dp[i+1])+1;
            }
        }
        // System.out.println(Arrays.toString(dp));
        int sum = 0;
        for(int i:dp) sum+=i;
        return sum;
    }
}