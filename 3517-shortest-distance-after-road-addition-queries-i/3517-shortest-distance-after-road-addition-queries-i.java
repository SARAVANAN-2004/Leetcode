class Solution {

    public int shortest(int n,List<List<Integer>> arr){
        Queue<Integer> que = new LinkedList<>();
        
        que.add(0);
        int distance = 0;
        boolean[] vis = new boolean[n];
        vis[0] = true;
        while(!que.isEmpty()){
            int size = que.size();
            for(int i = 0;i<size;i++){
                int curr = que.poll();
                if(curr == n-1){
                    return distance;
                }
                for(int num:arr.get(curr)){
                    if(!vis[num]){
                        vis[num] = true;
                        que.add(num);
                    }
                }
            }
            distance++;

        }
        return distance;
    }
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<>());
            adj.get(i).add(i+1);
        }
        int i = 0;
        int[] res = new int[queries.length];
        for(int[] q:queries){
            adj.get(q[0]).add(q[1]);
            res[i++] = shortest(n,adj);

        }
        for(List<Integer> arr:adj){
            System.out.println(arr);
        }
        
        
        return res;
    }
}