class Solution {
    public int maxArea(int[] height) {
        int left = 0 , right = height.length-1;
        int water = 0;
        while(left < right){
            int min = Math.min(height[left] , height[right]);
            water = Math.max(water,min*(right-left));
            // System.out.println(min+" "+left+" "+right+" "+water);

            if(min == height[left]) left++;
            else right--;
        }
        return water;
    }
}