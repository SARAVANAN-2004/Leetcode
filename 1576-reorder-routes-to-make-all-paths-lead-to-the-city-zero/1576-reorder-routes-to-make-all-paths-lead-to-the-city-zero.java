class Solution {
    public int minReorder(int n, int[][] connections) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        boolean[] vis = new boolean[n];
        for(int i[]:connections){
            adj.get(i[0]).add(new int[]{i[1],1});
            adj.get(i[1]).add(new int[]{i[0],0});
        }
        Queue<Integer> que = new LinkedList<>();
        que.add(0);
        vis[0] = true;
        int cnt = 0;
        while(!que.isEmpty()){
            int cur = que.poll();
            List<int[]> curAdj = adj.get(cur);
            for(int[] a:curAdj){
                if(!vis[a[0]]){
                    cnt += a[1];
                    vis[a[0]] = true;
                    que.add(a[0]);
                }

            }
        
        }

        return cnt;
    }
}