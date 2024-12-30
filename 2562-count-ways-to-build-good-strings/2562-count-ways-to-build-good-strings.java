class Solution {
    public int countGoodStrings(int low, int high, int z, int o) {
        int MOD = 1000000007;
        long[] dp = new long[high + 1];
        dp[0] = 1; 
        
        long sum = 0;
        for (int i = 1; i <= high; i++) {
            if (i >= z) {
                dp[i] = (dp[i] + dp[i - z]) % MOD;
            }
            if (i >= o) {
                dp[i] = (dp[i] + dp[i - o]) % MOD;
            }
            if (i >= low) {
                sum = (sum + dp[i]) % MOD;
            }
        }
        
        return (int) sum;
    }
}