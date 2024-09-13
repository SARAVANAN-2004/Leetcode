class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int prev = 0;
        int curr = 0;
        int i = 0;
        int i1 = 0;
        int i2 = 0;
        while(i < ((m+n)/2)+1){
            prev = curr;
            if(i1 < m && i2 < n){
                if(nums1[i1] < nums2[i2]){
                    curr = nums1[i1];
                    i1++;
                }else{
                    curr = nums2[i2];
                    i2++;
                }
            }else if(i1 < m){
                curr = nums1[i1];
                i1++;
            }else{
                curr = nums2[i2];
                i2++;
            }
            i++;
        }
        // System.out.println(prev + " "+ curr);
        if((m+n)%2 == 0){
            return (double)(curr+prev)/2.0;
        }
        
        return curr;

    }
}