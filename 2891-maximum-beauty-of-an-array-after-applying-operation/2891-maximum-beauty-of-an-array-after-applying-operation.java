class Solution {
    public int maximumBeauty(int[] nums, int k) {
        int cnt = 0;
        Arrays.sort(nums);
        int i = 0;
        int j = 0;
        for(j = 0;j<nums.length;j++){
            if(nums[j] - nums[i] > 2*k){
                cnt  = Math.max(cnt,j-i);
                i++;
            }
        }
        if(nums[j-1] - nums[i] <= 2*k){
                cnt  = Math.max(cnt,j-i);
               
        }
        return cnt;
    }
}