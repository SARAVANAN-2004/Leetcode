class Solution {
    public int maxSatisfaction(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        int[][] dp = new int[n+1][n+1];
        int maxVal = 0;
        for(int time = 1;time<=n;time++){
            for(int dish = time;dish<=n;dish++){
                dp[time][dish] = dp[time-1][dish-1] + (arr[dish-1]*time);
                maxVal = Math.max(dp[time][dish],maxVal);
            }
        }
        return maxVal;
    }
}