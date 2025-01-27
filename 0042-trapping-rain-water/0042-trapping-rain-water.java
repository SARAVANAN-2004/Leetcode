class Solution {
    public int trap(int[] height) {
        int left = 0,right = height.length -1;
        int lmax = 0,rmax = 0;
        int water = 0;
        while(left <= right){
            if(lmax<=rmax){
                lmax = Math.max(lmax,height[left]);
                water += (lmax - height[left++]);
            }else{
                rmax = Math.max(rmax,height[right]);
                water += (rmax - height[right--]);
            }
        }
        return water;
    }
}