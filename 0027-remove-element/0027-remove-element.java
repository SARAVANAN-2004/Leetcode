class Solution {
    public int removeElement(int[] nums, int val) {
        int k = 0;
        int l = 0;
        int r = nums.length-1;
        while(l<=r){
            if(nums[l] == val){
                
                nums[l] = nums[r--];
            }else{
                k++;
                l++;
            }
        }
        return k;
    }
}