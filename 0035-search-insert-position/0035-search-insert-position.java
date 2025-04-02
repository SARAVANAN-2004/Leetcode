class Solution {
    public int searchInsert(int[] nums, int target) {
        if(target <= nums[0]) return 0;
        int n = nums.length;
        if(target > nums[n-1]) return n;
        int l = 0, r = n-1;
        int mid = (l+r)/2;
        while(l <= r){
            mid = (l+r)/2;
            if(nums[mid] == target){
                return mid;
            }

            if(nums[mid] > target){
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        return l;
    }
}