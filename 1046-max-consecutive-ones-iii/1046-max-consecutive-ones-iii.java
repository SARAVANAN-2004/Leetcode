class Solution {
    public int longestOnes(int[] nums, int k) {
        int l = 0,r = 0;
        int maxi = 0;
        int n = nums.length;
        int cnt = 0;
        while(r < n){
            
            while(r < n && (nums[r] == 1 || (nums[r] == 0 && k>0))){
                    cnt++;
                    if(nums[r] == 0){
                        k--;
                    }
                    r++;
                }
                maxi = Math.max(maxi,cnt);
                // System.out.println(" cnt "+cnt);
           
                if(l == r){
                    while(r < n && nums[r] == 0){
                        r++;
                        l++;
                    }
                // System.out.println("equal "+cnt);

                }else if(nums[l] == 1){
                    cnt--;
                    l++;
                // System.out.println("1 "+cnt);

                }else{
                    if(nums[l] == 0){
                        k++;
                        l++;
                        cnt--;
                    //  System.out.println("0 "+k+" "+cnt);
                    }
                
                // maxi = Math.max(maxi,cnt);
                // System.out.println(cnt);

            }
        }
        return maxi;
    }
}