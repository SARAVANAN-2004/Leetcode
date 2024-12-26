class Solution {
    int cnt = 0;
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        dfs(nums,sum,target,0);
        return cnt;
    }

    void dfs(int[] arr,int sum ,int target,int idx){
        if(idx == arr.length){
            if(sum == target){
                cnt++;
            }
            return;
        }

        dfs(arr,sum+arr[idx],target,idx+1);
        dfs(arr,sum-arr[idx],target,idx+1);
    }
}