class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        
        List<Integer> ans = new ArrayList<>();
        solve(k,n,ans,0,0,0);
        return res;
    }

    void solve(int k,int sum,List<Integer> ans,int cur,int i,int size){
        if(k == size){
            if(cur == sum){
                
                res.add(new ArrayList<>(ans));
                
                return;
            }
            return;
        }
        if(ans.size() >= k || cur >= sum || i >= 9){
            return;
        }
        solve(k,sum,ans,cur,i+1,size);
        ans.add(i+1);
        solve(k,sum,ans,cur+i+1,i+1,size+1);
        ans.remove(size);
    }
}