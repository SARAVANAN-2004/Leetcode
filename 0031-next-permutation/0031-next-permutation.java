class Solution {
    public void nextPermutation(int[] nums) {
        int b_ind = getIdx(nums);
        if(b_ind == -1){
            reverse(0,nums);
            return;
        }

        int nextLargest = getLargest(nums,nums[b_ind]);
        int temp = nums[nextLargest];
        nums[nextLargest] = nums[b_ind];
        nums[b_ind] = temp;

        reverse(b_ind+1,nums);
    }
    int getIdx(int[] nums){
        for(int i = nums.length-2;i>=0;i--){
            if(nums[i] < nums[i+1]) return i;
        }
        return -1;
    }

    int getLargest(int[] nums,int num){
        for(int i = nums.length-1;i>=0;i--){
            if(nums[i] > num) return i;
        }
        return num;
    }

    void reverse(int l, int[] nums){
        int r = nums.length-1;
        while(l < r){
            int t = nums[l];
            nums[l] = nums[r];
            nums[r] = t;
            l++;
            r--;
        }
    }
}