class Solution {
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        int[] smallest = new int[n];
        int[] largest = new int[n];
        smallest[0] = nums[0];
        largest[n-1] = nums[n-1];
        for(int i = 1;i<n;i++){
            smallest[i] = Math.min(nums[i],smallest[i-1]);
        }

        for(int i = n-2;i>=0;i--){
            largest[i] = Math.max(nums[i],largest[i+1]);
            if(nums[i] != smallest[i] && nums[i] != largest[i]) return true;
        }
        return false;
    }
}