class Solution {
    public int jump(int[] nums) {
        int jumps = 1,step = nums[0] , maxIdx = nums[0], n = nums.length;
        if(n == 1) return 0;

        for(int i = 1;i<n-1;i++){
            // if(i == n-1) return jumps;
            
            maxIdx = Math.max(maxIdx,i+nums[i]);
            step--;
            if(step == 0){
                jumps++;
                step = maxIdx - i;
            }
            
            
            
        }
        return jumps;
    }
}