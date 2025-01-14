class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length -1,n = nums.length;
        int mid = -1;
        while(l < r){
            mid = (l+r)/2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[mid] > nums[r]){
                l = mid+1;
            }else{
                r = mid;
            }
        }
        if(l == 0) return bsearch(nums,0,n-1,target);
        if(nums[0] <= target &&   target <= nums[l-1]){
            return bsearch(nums,0,l-1,target);
        }
        return bsearch(nums,l,n-1,target);

        
    }
    public int bsearch(int[] nums,int l,int r,int target){
        while(l <= r){
            int mid = (l+r)/2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[mid] < target){
                l = mid+1;
            }else{
                r = mid-1;
            }
        }
        return -1;
    }
}