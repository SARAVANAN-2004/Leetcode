class Solution {
    int[] dis;
    boolean[] vis;
    int n;
    List<List<Integer>> adj;

    public int closestMeetingNode(int[] edges, int node1, int node2) {
        n = edges.length;
        adj = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
            if (edges[i] != -1) {
                adj.get(i).add(edges[i]);
            }
        }

        dis = new int[n];
        vis = new boolean[n];
        Arrays.fill(dis, -1);
        bfs(node1);
        int[] dist1 = dis.clone(); 
        dis = new int[n];
        vis = new boolean[n];
        Arrays.fill(dis, -1);
        bfs(node2);
        int[] dist2 = dis.clone(); 


        int minDist = Integer.MAX_VALUE;
        int ans = -1;

        for (int i = 0; i < n; i++) {
            if (dist1[i] != -1 && dist2[i] != -1) {
                int max = Math.max(dist1[i], dist2[i]);
                if (max < minDist) {
                    minDist = max;
                    ans = i;
                }
            }
        }

        return ans;
    }

    void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        vis[start] = true;
        dis[start] = 0;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int neighbor : adj.get(cur)) {
                if (!vis[neighbor]) {
                    vis[neighbor] = true;
                    dis[neighbor] = dis[cur] + 1;
                    queue.add(neighbor);
                }
            }
        }
    }
}
