class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[] prefix = solve(nums);
        int i = 0, j = n-1;
        while(i < j){
            int temp = nums[i];
            nums[i++] = nums[j];
            nums[j--] = temp;
        }
        int[] suffix = solve(nums);
        int maxi = prefix[0];
        for( i = 0;i<n;i++){
            maxi = Math.max(maxi,Math.max(prefix[i],suffix[i]));
        }
        return maxi;
    }
    int[] solve(int[] nums){
        int n = nums.length;
        int[] arr = new int[n];
        int prev = 1;
        for(int i = 0;i<n;i++){
            if(nums[i] == 0){
                arr[i] = 0;
                prev = 1;
            }else{
                prev *= nums[i];
                arr[i] = prev;
            }
        }
        return arr;
    }
}