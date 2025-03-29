class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    void swap(int[] nums,int i,int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        int cur = 0;
        for(int si = cur;si<n;si++){
            swap(nums,cur,si);
            solve(nums,n,cur+1);
            swap(nums,cur,si);
        }
        return ans;
    }

    public void solve(int[] nums,int n,int cur){
        if(cur == n){
            List<Integer> temp = new ArrayList<>();
            for(int i:nums){
                temp.add(i);
            }
            ans.add(temp);
            return;
        }
        for(int si = cur;si<n;si++){
            swap(nums,cur,si);
            solve(nums,n,cur+1);
            swap(nums,cur,si);
        }
    }
}