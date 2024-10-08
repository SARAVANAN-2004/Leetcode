class Solution {
    public int longestSubarray(int[] nums) {
        int max = Integer.MIN_VALUE;
        for(int n:nums){
            max = Math.max(max,n);
        }
        int cursub = 0;
        int maxsub = 0;
        for(int n:nums){
            if(n == max){
                cursub++;
            }else{
                maxsub = Math.max(cursub,maxsub);
                cursub = 0;
            }
        }
        return Math.max(cursub,maxsub);
    }
}