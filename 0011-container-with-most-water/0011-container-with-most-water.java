class Solution {
    public int maxArea(int[] height) {
        int l = 0 , r = height.length -1 ;
        int maxi = 0;
        while(l < r){
            maxi = Math.max(maxi,Math.min(height[l],height[r]) * (r - l ));

            if(height[l] <= height[r]){
                l++;
            }else{
                r--;
            }
        }
        return maxi;
    }
}