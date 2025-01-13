class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n+2];
        arr[0] = arr[n+1] = 1;
        for(int i = 0;i<n;i++){
            arr[i+1] = nums[i];
        }
        // System.out.println(Arrays.toString(arr));

        int[][] dp = new int[n+1][n+1];
       for(int[] i:dp){
            Arrays.fill(i,-1);
        }
       int max = solve(arr,dp,1,n);
        
       return max;
    }
    public int solve(int[] arr,int[][] dp,int left,int right){
        if(left > right) return 0;
        if(dp[left][right] != -1){
            return dp[left][right];
        }
        int max = Integer.MIN_VALUE;
        for(int i = left;i<=right;i++){
            int cost = (arr[left-1] * arr[i] * arr[right+1]) + 
            solve(arr,dp,left,i-1) + solve(arr,dp,i+1,right);
            max = Math.max(cost,max);

        }
        dp[left][right] = max;
        return max;
    }
}