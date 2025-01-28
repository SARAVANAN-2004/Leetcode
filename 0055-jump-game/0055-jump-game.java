class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length, idx = nums[0];
         for(int i = 0;i<n && i <= idx;i++){
            idx = Math.max(idx,i+nums[i]);
         }
         return idx >= nums.length-1;
    }
}