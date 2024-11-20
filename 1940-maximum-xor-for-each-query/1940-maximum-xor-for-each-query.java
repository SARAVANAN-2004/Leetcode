class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int n = nums.length;
        int[] arr = new int[n];
        int pre = 0;
        int k = ((int)(Math.pow(2,maximumBit))-1);
        for(int i = 0;i<n;i++){
            pre ^= nums[i];
            arr[n-i-1] = pre^k;
            
        }

        return  arr;
    }
}