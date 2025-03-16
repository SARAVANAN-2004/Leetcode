class Solution {
    Stack<Integer> stk;
    boolean []canvis;
    boolean []visiting;
    List<List<Integer>> adj;
    public int[] findOrder(int n, int[][] prerequisites) {
        adj = new ArrayList<>();
        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i[]:prerequisites){
            adj.get(i[0]).add(i[1]);
        }
        stk = new Stack<>();
        canvis = new boolean[n];
        visiting = new boolean[n];
        for(int i = 0;i<n;i++){
            if(!canvis[i]){
                if(dfs(i,n)){
                    return new int[]{};
                }
            }
        }
        // System.out.println(stk);
        int[] ans = new int[n];
        int j = 0;
        for(int i:stk){
            ans[j++] = i;
        }
        return ans;
    }

    boolean dfs(int node,int n){
        if(visiting[node]) return true;
        if(canvis[node]) return false;
        visiting[node] = true;
        List<Integer> curAdj = adj.get(node);
        for(int i :curAdj){
            if(!canvis[i]){
                if(dfs(i,n)){
                    return true;
                }
            }
        }
        canvis[node] = true;
        visiting[node] = false;
        stk.push(node);
        return false;
    }
}