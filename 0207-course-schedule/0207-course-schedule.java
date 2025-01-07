class Solution {
    
    public boolean canFinish(int n, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] a:prerequisites){
            adj.get(a[0]).add(a[1]);
        }
        boolean[] canvis = new boolean[n];
        boolean[] visiting = new boolean[n];
        for(int i = 0;i<n;i++){
            if(dfs(canvis,visiting,i,adj)){
                return false;
            }
            canvis[i] = true;
        }  

        return true;
    }
    public boolean dfs(boolean []canvis,boolean []visiting,int i,List<List<Integer>> adj){
        if(visiting[i]) return true;
        if(canvis[i]) return false;
        visiting[i] = true;
        for(int j:adj.get(i)){
            
            if(dfs(canvis,visiting,j,adj)){
                return true;
            }
        }

        visiting[i] = false;
        canvis[i] = true;
        return false;
    }

}