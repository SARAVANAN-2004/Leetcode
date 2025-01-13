class Solution {
    public int maxArea(int[] height) {
        
        int left = 0 , right = height.length - 1;
        int lmax = height[0] , rmax = height[right];
        int res = Math.min(lmax,rmax) * (right - left);
        while(left < right){
            if(height[left] < height[right]){
                left++;
                lmax = Math.max(lmax,height[left]);
            }else{
                right--;
                rmax = Math.max(rmax,height[right]);
            }
            res = Math.max(Math.min(lmax,rmax) * (right - left),res);

        }
        return res;
    }
}