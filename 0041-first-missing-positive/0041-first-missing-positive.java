class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        boolean one_avail = false;
        for(int i = 0;i<n;i++){
            if(nums[i] == 1){
                one_avail = true;
            }
            if(nums[i] <= 0 || nums[i] > n){
                nums[i] = 1;
            }
        }
        if(!one_avail) return 1;
        for(int i = 0;i<n;i++){
            int idx = Math.abs(nums[i]);
            if(idx == n){
                nums[0] = -Math.abs(nums[0]);
            }
            else{
                nums[idx] = -Math.abs(nums[idx]); 
            }
        }

        for(int i = 1;i<n;i++){
            if(nums[i] > 0)
            return i;
        }
        if(nums[0] > 0){
            return n;
        }

        return n+1;



    }
}