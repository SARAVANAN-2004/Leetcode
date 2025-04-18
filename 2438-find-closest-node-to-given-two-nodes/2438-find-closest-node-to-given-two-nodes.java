class Solution {
    int[] dis;
    boolean[] vis;
    int n;
    List<List<Integer>> adj;
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        n = edges.length;
        adj = new ArrayList<>();
        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<>());
            if(edges[i] != -1){
                adj.get(i).add(edges[i]);
            }
        }



        dis = new int[n];
        vis = new boolean[n];
        Arrays.fill(dis,-1);
        boolean cycle =  solve(edges,node1);
        if(cycle) return -1;
        int[] dist_1 =new int[n];
        for(int i = 0;i<n;i++) dist_1[i] = dis[i];
        Arrays.fill(dis,-1);
        vis = new boolean[n];
        cycle =  solve(edges,node2);
        if(cycle) return -1;
        int[] dist_2 =dis;

        
        int min = n;
        int node = -1;
        for(int i = 0;i<n;i++){
            if(dist_1[i] != -1 && dist_2[i] != -1){
            int max = Math.max(dist_1[i],dist_2[i]);
            if(max < min) {
                min = max;
                node = i;
            }
            }
        }
        return node;
        
    }

    boolean solve(int[] nums,int node){
        if(node == -1) return false;
        Queue<Integer> que = new LinkedList<>();
        que.add(node);
        vis[node] = true;
        int d = 0;
        while(!que.isEmpty()){
            int size = que.size();
            for(int i = 0;i<size;i++){
                int cur = que.poll();
                dis[cur] = d;
                for(int j :adj.get(cur)){
                    if(!vis[j]){
                        vis[j] = true;
                        que.add(j);
                    }
                }
            }
            d++;
        }
        return false;
    }
}