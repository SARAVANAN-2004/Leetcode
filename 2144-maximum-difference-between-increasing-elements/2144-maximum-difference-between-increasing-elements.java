class Solution {
    public int maximumDifference(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];
        arr[n-1] = nums[n-1];
        for(int i = n-2;i>=0;i--){
            arr[i] = Math.max(arr[i+1],nums[i]);
        }
        int maxi = -1;
        for(int i= 0;i<n;i++){
            if(nums[i] < arr[i] ){
                maxi = Math.max(arr[i]-nums[i],maxi);
            }
        }
        return maxi;
     }
}