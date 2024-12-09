class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        boolean[] arr = new boolean[queries.length];
        int[] prefix = new int[nums.length];
        for(int i = 1;i<nums.length;i++){
            if(nums[i] %2 == nums[i-1]%2){
                prefix[i] = prefix[i-1]+1;
            }else{
                prefix[i] = prefix[i-1];
            }
        }
        int i = 0;
        for(int[] q:queries){
            int st = q[0];
            int to = q[1];
            arr[i++] = prefix[st]-prefix[to] == 0;
        }
        return arr;
    }
}