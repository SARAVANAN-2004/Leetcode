class Solution {
    public int removeDuplicates(int[] nums) {
        int l = 0;
        int r = 0;
        int n = nums.length;
        while (r<n){
            int cnt = 1;
            while (r+1<n && nums[r] == nums[r+1]){
                cnt++;
                r++;
            }
            int no_of_left_ptr_move = Math.min(2,cnt);
            for(int i = 0;i < no_of_left_ptr_move;i++){
                nums[l] = nums[r];
                l++;
            }
            r++;
        }
        return l;

    }
}