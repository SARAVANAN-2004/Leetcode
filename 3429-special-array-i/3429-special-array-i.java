class Solution {
    public boolean isArraySpecial(int[] nums) {
        int n = nums.length;
        for(int i =0;i<n;i++){
            nums[i] = nums[i]%2;
            if(i> 0){
                if(nums[i-1] == nums[i]){
                    return false;
                }
            }

        }
        return true;
       
    }
}