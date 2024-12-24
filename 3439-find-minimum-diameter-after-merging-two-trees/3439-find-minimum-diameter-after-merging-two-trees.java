class Solution {
    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        int dia1 = findDiameter(edges1);
        int dia2 = findDiameter(edges2);

        int r1 = (dia1+1)/2;
        int r2 = (dia2+1)/2;
        int sum = 1+r1+r2;

        return Math.max(sum,Math.max(dia1,dia2));
    }

    public int findDiameter(int[][] edge){
        if(edge.length == 0) return 0;

       Map<Integer, List<Integer>> adj = new HashMap<>();

        for(int[] ed:edge){
            adj.computeIfAbsent(ed[0],k -> new ArrayList<>()).add(ed[1]);
            adj.computeIfAbsent(ed[1],k -> new ArrayList<>()).add(ed[0]);
        }
        int stnode = edge[0][0];
        int[] fartest = bfs(stnode,adj);
        int[] dia = bfs(fartest[0],adj);

        return dia[1];
    }

    public int[] bfs(int st, Map<Integer, List<Integer>> adj){
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> vis = new HashSet<>();
        Map<Integer,Integer> dist = new HashMap<>();

        queue.offer(st);
        vis.add(st);
        dist.put(st,0);
        int maxDist = 0;
        int fartest = st;

        while(!queue.isEmpty()){
            int cur  = queue.poll();

            for(int nei:adj.getOrDefault(cur,new ArrayList<>())){
                if(!vis.contains(nei)){
                    vis.add(nei);
                    queue.offer(nei);
                    dist.put(nei,dist.get(cur)+1);

                    if(dist.get(nei) > maxDist){
                        fartest = nei;
                        maxDist = dist.get(nei);
                    }
                }
            }
        }

        return new int[]{fartest,maxDist};
    }
}