class Solution {

    public int mincostTickets(int[] days, int[] costs) {
        int last = days[days.length - 1];
        int[] dp = new int[last+1];
        int i = 0;
        for(int day = 1;day<=last;day++){
            if(day<days[i]){
                dp[day] = dp[day-1];
            }else{
                i++;
                dp[day] = dp[day-1] + costs[0];
                dp[day] = Math.min(dp[day - 1] + costs[0],
                        Math.min(dp[Math.max(0, day - 7)] + costs[1],
                                dp[Math.max(0, day - 30)] + costs[2]));
            }
        }
        return dp[last];
    }
}