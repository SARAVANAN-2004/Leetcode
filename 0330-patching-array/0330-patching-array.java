class Solution {
    public int minPatches(int[] nums, int n) {
        int cnt = 0;
        long till = 0;
        int i = 0;
        // for(int i = 0;till < n && i < nums.length;i++){
        //     if(till > nums[i]-1){
        //         till+=nums[i];
        //     }else{
        //         while(till < n && till < nums[i]-1){
        //             till += (till+1);
        //             cnt++;
        //         }
        //         till += nums[i];
        //     }
        // }
        while(i < nums.length && till < n){
            if(till >= nums[i]-1){
                till+=nums[i++];
            }else{
                till += (till+1);
                cnt++;
            }
        }
        while(till < n){
            till += (till+1);
            cnt++;
        }
        return cnt;

    }
}