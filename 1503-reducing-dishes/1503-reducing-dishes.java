class Solution {
    public int maxSatisfaction(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        int[][] dp = new int[n+1][n+1];
        int maxVal = 0;
        for(int dish = 1;dish<=n;dish++){
            for(int time = 1;time<=dish;time++){
                dp[dish][time] = dp[dish-1][time-1]+arr[dish-1]*time;
                maxVal = Math.max(maxVal,dp[dish][time]);
            }
        }
        return maxVal;
    }
}