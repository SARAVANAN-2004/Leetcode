class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        solve(candidates,0,0,target,candidates.length,new ArrayList<>());
        return res;
    }

    void solve(int[] arr,int sum,int st,int target,int n,List<Integer> temp){
        if(sum == target){
            res.add(new ArrayList<>(temp));
            return;
        }
        if(sum > target){
            return;
        }
        for(int i = st;i<n;i++){
            temp.add(arr[i]);
            solve(arr,sum+arr[i],i,target,n,temp);
            temp.remove(temp.size()-1);
        }
    }
}