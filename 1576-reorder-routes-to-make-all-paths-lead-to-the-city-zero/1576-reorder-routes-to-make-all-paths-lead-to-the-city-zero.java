class Solution {
    int cnt = 0;
    List<List<int[]>> adj;
    boolean[] vis;
    public int minReorder(int n, int[][] connections) {
        adj = new ArrayList<>();
        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        vis = new boolean[n];
        for(int i[]:connections){
            adj.get(i[0]).add(new int[]{i[1],1});
            adj.get(i[1]).add(new int[]{i[0],0});
        }
        
        dfs(0);
        return cnt;
    }
    void dfs(int cur){
        
        vis[cur] = true;

        for(int[] a:adj.get(cur)){
            if(!vis[a[0]]){
                cnt += a[1];
                dfs(a[0]);
            }
        }
    }
}