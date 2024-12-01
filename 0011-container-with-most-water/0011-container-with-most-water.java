class Solution {
    public int maxArea(int[] height) {
       int l = 0,r = height.length-1;

       int max = 0;

       while(l < r){
        int left = height[l], right = height[r];

        if(left < right){
            int water = left * (r-l);
            max = Math.max(water,max);
            l++;
        }else{
            int water = right * (r-l);
            max = Math.max(water,max);
            r--;
        }
       }
       return max;
        
    }
}