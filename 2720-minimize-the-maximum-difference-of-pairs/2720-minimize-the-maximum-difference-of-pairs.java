class Solution {
    public int minimizeMax(int[] nums, int p) {
        if(p == 0 ) return 0;
        Arrays.sort(nums);
        int n = nums.length;
        int l = 0 , r = nums[n-1] - nums[0];
        int res = 0;
        while(l <= r){
            int mid = (l+r)/2;
            if(isvalidTherhold(mid,p,nums)){
                res = mid;
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        return res;
    }
    public boolean isvalidTherhold(int ther,int p,int[] nums){
        int cnt = 0;
        int i = 0;
        while(i < nums.length-1){
            if(Math.abs(nums[i] - nums[i+1]) <= ther){
                cnt++;
                i++;
            }
            i++;
            if(cnt == p) return true;
        }
        return false;
    }
}