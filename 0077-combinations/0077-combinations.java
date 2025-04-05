class Solution {
    List<List<Integer>> res = new ArrayList<>();
    boolean[] vis;
    public List<List<Integer>> combine(int n, int k) {
        vis = new boolean[n+1];
        solve(1,n,k,new ArrayList<>());
        return res;
    }

    void solve(int st,int n,int k,List<Integer> temp){
        if(temp.size() == k){
            
            // System.out.println();
            res.add(new ArrayList<>(temp));
            return;
        }

        for(int i = st;i<=n;i++){
            if(!vis[i]){
                temp.add(i);
                vis[i] = true;
                solve(i+1,n,k,temp);
                temp.remove(temp.size()-1);
                vis[i] = false;
            }
        }
    }
}