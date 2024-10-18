class Solution {
    int max = 0;
    int freq = 0;
    public int countMaxOrSubsets(int[] nums) {
        

        solve(nums,0,0);
        return freq;
    }
    void solve(int[] nums,int curidx,int curr){
        if(curr > max){
            max = curr;
            freq = 1;
        }else if(curr == max){
            freq++;
        }

        for(int i = curidx;i<nums.length;i++){
            solve(nums,i+1,curr|nums[i]);
        }
    }
}