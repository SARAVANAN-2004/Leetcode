class Solution {
    public int countSubarrays(int[] nums) {
        int l = 0,cnt  = 0;
        for(int r = 2;r<nums.length;r++){
            if(nums[r-1] %2 == 0 && nums[r-1]/2 == nums[l]+nums[r]){
                cnt++;
            }
            l++;
        }
        return cnt;
    }
}