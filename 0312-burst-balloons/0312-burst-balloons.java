class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] num = new int[n+2];
        num[0] = num[n+1] = 1;
        for(int i = 0;i<n;i++){
            num[i+1] = nums[i];
        }
        n+=2;
        int[][] dp = new int[n][n];
        for(int i = 0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(num,dp,1,n-2);
    }
    int solve(int[] arr,int[][] dp,int left,int right){
        if(left > right){
            return 0;
        }
        if(dp[left][right] != -1){
            return dp[left][right];
        }
        int max = -1;
        for(int i = left;i<=right;i++){
            max = Math.max(max,solve(arr,dp,left,i-1) + solve(arr,dp,i+1,right)+(arr[left-1]*arr[i]*arr[right+1]));
        }
        dp[left][right] = max;
        return max;
    }
}