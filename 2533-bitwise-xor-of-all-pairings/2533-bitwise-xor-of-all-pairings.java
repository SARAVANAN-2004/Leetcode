class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        int xor = 0;
        if(l2%2 != 0){
            for(int i:nums1){
                xor ^= i;
            }
        }
        if(l1%2 != 0){
            for(int i:nums2){
                xor ^= i;
            }
        }

        return xor;
    }
}