class Solution {
    public int longestOnes(int[] nums, int k) {
        int o = 0, z = 0, j = 0,n = nums.length;
        int maxi = 0;
        for(int i = 0;i<n;i++){
            if(nums[i] == 1) o++;
            else z++;
            // System.out.println(i+" "+j+" "+o+" "+z+" "+maxi);
            while(j <= i && z >k){
                // System.out.println(i+" "+j);
                if(nums[j] == 1) o--;
                else z--;
                j++;
            }
            // System.out.println(i+" "+j+" "+o+" "+z+" "+maxi);
            // System.out.println();
            maxi = Math.max(maxi,o+z);
        }
        return maxi;
    }
}