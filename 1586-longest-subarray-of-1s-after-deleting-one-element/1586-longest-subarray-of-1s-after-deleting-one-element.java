class Solution {
    public int longestSubarray(int[] nums) {
        int o = 0, z = 0, maxi = 0,j = 0;
        int n = nums.length;
        for(int i = 0;i<n;i++){
            if(nums[i] == 1) o++;
            else z++;

            while( j < n && z > 1){
                if(nums[j] == 1) o--;
                else z--;
                j++;
            }
            maxi = Math.max(maxi,o+z-1);
        }

        return maxi;
    }
}