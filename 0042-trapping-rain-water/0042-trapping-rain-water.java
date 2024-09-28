class Solution {
    public int trap(int[] height) {
        int left = 0,right = height.length -1;
        int lmax = height[left],rmax = height[right];
        int water = 0;
        while(left < right){
            if(lmax<=rmax){

                water += (lmax - height[left++]);
                lmax = Math.max(lmax,height[left]);
            }else{
                water += (rmax - height[right--]);
                rmax = Math.max(rmax,height[right]);

            }
        }
        return water;
    }
}