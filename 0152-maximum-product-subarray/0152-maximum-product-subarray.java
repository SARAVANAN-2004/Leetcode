class Solution {
    public int maxProduct(int[] nums) {
        int prev = 1;
        int suff = 1;
        int maxi = nums[0];
        int n = nums.length;
        for(int i = 0;i<n;i++){
            if(prev == 0){
                prev = 1;
            }
            if(suff == 0){
                suff = 1;
            }
            suff *= nums[n-i-1];
            prev *= nums[i];

            maxi = Math.max(maxi,Math.max(prev,suff));
        }
        return maxi;
    }
}