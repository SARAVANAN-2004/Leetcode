class Solution {
    boolean[] vis;
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        vis = new boolean[n];
       
        dfs(rooms,0);
        for(boolean v:vis){
            if(!v) return false;
        }
        return true;
    }
    void dfs(List<List<Integer>> rooms,int i){
        
        vis[i] = true;
        for(int j :rooms.get(i)){
            if(!vis[j]){
                dfs(rooms,j);
            }
        }
    }

}