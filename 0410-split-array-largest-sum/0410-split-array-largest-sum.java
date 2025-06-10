class Solution {
    public int splitArray(int[] nums, int k) {
        int low = nums[0];
        int high = nums[0];
        for(int i = 1;i<nums.length;i++){
            low = Math.max(low,nums[i]);
            high += nums[i];
        }

        while(low <= high){
            int mid = (low + high)/2;
            int cnt  = numberOfSubarray(nums,mid);

            if(cnt > k){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return low;
    }
    int numberOfSubarray(int[] arr,int max_val){
        int subarray = 1, cur_val = arr[0];
        for(int i = 1;i<arr.length;i++){
            if(cur_val + arr[i] <= max_val){
                cur_val += arr[i];
            }else{
                subarray++;
                cur_val = arr[i];
            }
        }
        return subarray;
    }
}