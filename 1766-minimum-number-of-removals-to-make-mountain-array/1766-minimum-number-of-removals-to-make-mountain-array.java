class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        int[] Lis = new int[n];
        int[] Lds = new int[n];
        Arrays.fill(Lis,1);
        Arrays.fill(Lds,1);

        for(int i = 0;i<n;i++){
            for(int j = 0;j<i;j++){
                if(nums[i] > nums[j]){
                    Lis[i] = Math.max(Lis[i],Lis[j]+1);
                }
            }
        }

        for(int i = n-1;i>=0;i--){
            for(int j = i+1;j<n;j++){
                if(nums[i] > nums[j]){
                    Lds[i] = Math.max(Lds[i],Lds[j]+1);
                }
            }
        }
        // System.out.println(Arrays.toString(Lis));
        // System.out.println(Arrays.toString(Lis));
        int min = Integer.MAX_VALUE;
        for(int i = 0;i<n;i++){
            if(Lis[i] > 1 && Lds[i] > 1){
                min = Math.min(min,n+1-Lis[i] -Lds[i]);
            }
        }
        return min;
    }
}