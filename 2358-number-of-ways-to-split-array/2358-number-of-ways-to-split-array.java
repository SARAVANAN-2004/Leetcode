class Solution {
    public int waysToSplitArray(int[] nums) {
        int n = nums.length;
        long[] prefix = new long[n];
        long sum = 0;
        for(int i = 0;i<n;i++){
            sum += nums[i];
            prefix[i] = sum;
        }
        int cnt = 0;
        for(int i = 0;i<n-1;i++){
            if(prefix[i] >= prefix[n-1] - prefix[i]){
                cnt++;
            }
        }
        return cnt;
    }
}