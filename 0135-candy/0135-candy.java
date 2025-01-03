class Solution {
    public int candy(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];

        Arrays.fill(dp,1);

        for(int i = 1;i<n;i++){
            if(arr[i-1] < arr[i]){
                dp[i] = dp[i-1]+1;
            }
        }
        // System.out.println(Arrays.toString(dp));
        for(int i = n-2;i>=0;i--){
            if(arr[i] > arr[i+1]){
                dp[i] = Math.max(dp[i],dp[i+1]+1);
            }
        }
        // System.out.println(Arrays.toString(dp));
        int sum = 0;
        for(int i :dp){
            sum+=i;
        }
        return sum;
    }
}