class Solution {
    public int minimumSize(int[] nums, int maxOp) {
        int r = nums[0];
        for(int i:nums){
            r = Math.max(r,i);
        }

        int l = 1;
        int res = r;
        while(l<r){
            int mid = (l+r)/2;
            if(canDivide(mid,nums,maxOp)){
                r = mid;
                res = r;
            }else{
                l = mid+1;
            }
        }
        return l;
    }
    boolean canDivide(int max_balls,int[] nums,int maxOp){
        int ops = 0;
        for(int n:nums){
            ops += Math.ceil(n/(double)max_balls)-1;
            if(ops > maxOp){
                return false;
            }
        }
        return true;
    }
}