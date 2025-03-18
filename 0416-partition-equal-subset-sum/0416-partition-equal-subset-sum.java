class Solution {
    Boolean[][] dp;
    public boolean canPartition(int[] nums) {
        int sum = 0;
        
        for(int i :nums){
            sum+=i;
        }
        dp = new Boolean[nums.length+1][(sum/2)+1];
        return sum%2 == 1? false :solve(nums,0,sum/2,0);
    }

    boolean solve(int[] nums,int i,int sum,int cur){
        if(sum == cur) return true;

        
        if(cur > sum || i == nums.length) return false;
        if(dp[i][cur] != null) return dp[i][cur];

        dp[i][cur] = solve(nums,i+1,sum,cur+nums[i]) || solve(nums,i+1,sum,cur);
        return dp[i][cur];
    }
}