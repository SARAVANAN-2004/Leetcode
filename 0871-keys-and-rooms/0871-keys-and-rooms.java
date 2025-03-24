class Solution {
   
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] vis= new boolean[n];
       
        Queue<Integer> queu = new LinkedList<>();
        queu.add(0);

        while(!queu.isEmpty()){
            int i = queu.poll();
            vis[i] = true;
            for(int j :rooms.get(i)){
                if(!vis[j]){
                    queu.add(j);
                }
            }
        }

        for(boolean v:vis){
            if(!v) return false;
        }
        return true;
    }
    // void dfs(List<List<Integer>> rooms,int i){
        
    //     vis[i] = true;
    //     for(int j :rooms.get(i)){
    //         if(!vis[j]){
    //             dfs(rooms,j);
    //         }
    //     }
    // }

}