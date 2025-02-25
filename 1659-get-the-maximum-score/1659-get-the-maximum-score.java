class Solution {
    public int maxSum(int[] nums1, int[] nums2) {
        int i1 = 0, i2 = 0;
        long sum1= 0, sum2 = 0;
        long maxScore = 0;
        int l1 = nums1.length, l2 = nums2.length;
        while(i1 < l1 && i2 < l2){
            if(nums1[i1] == nums2[i2]){
                maxScore += Math.max(sum1,sum2)+ nums1[i1];
                sum1 = 0;
                sum2 = 0;
                i1++;
                i2++;
            }else if(nums1[i1] < nums2[i2]){
                sum1 += nums1[i1++];
            }else{
                sum2 += nums2[i2++];
            }
        }
        while(i1 < l1){
            sum1 += nums1[i1++];
        }
        while(i2 < l2){
            sum2 += nums2[i2++];
        }
        maxScore += Math.max(sum1,sum2);
        return (int)(maxScore%1000000007);
    }
}