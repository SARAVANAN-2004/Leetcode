class Solution {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        // System.out.println(Arrays.toString(nums));
        int n = nums.length;
        int[][] arr = new int[n/3][3];
        int idx = 0;
        for(int i = 0;i<n;i+=3){
            for(int j = i;j<=i+2;j++){
                if(nums[j] - nums[i] > k) return new int[0][0];
                arr[idx][j-i] = nums[j];
            }
            idx++;
        }
        return arr;
    }
}