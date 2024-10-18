class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        List<Integer> temp = new ArrayList<>();
        solve(ans,temp,nums,n,0);
        return ans;
    }
    public static void solve(List<List<Integer>> ans,List<Integer> temp,int[] nums,int n,int st ){
        if(st == n){
            ans.add(new ArrayList<>(temp));
            return;
        }
        
        temp.add(nums[st]);
        solve(ans,temp,nums,n,st+1);
        
        temp.remove(temp.size()-1);
        solve(ans,temp,nums,n,st+1);
        

    }
}