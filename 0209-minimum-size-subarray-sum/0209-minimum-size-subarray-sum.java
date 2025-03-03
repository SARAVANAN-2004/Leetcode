class Solution {
    public int minSubArrayLen(int k, int[] arr) {
        int l = 0,r= 0,n = arr.length;
        int sum = 0,size = Integer.MAX_VALUE;
        while(r < n && l <= r){
            
                sum+=arr[r];
                r++;
            
                while(l<=r && sum>=k){
                // System.out.println(l+" "+r+" "+n+" "+sum);
                size = Math.min(size,r-l);
                sum-=arr[l];
                l++;
                }
                
            }
        
        return size == Integer.MAX_VALUE?0:size;
    }
}