class Solution {
    List<Integer> circuit;
    public int[][] validArrangement(int[][] pairs) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer,Integer> degree = new HashMap<>();

        for(int[] pair:pairs){
            int st = pair[0],end = pair[1];

            graph.computeIfAbsent(st,k-> new ArrayList<>()).add(end);

            degree.put(st,degree.getOrDefault(st,0)+1);
            degree.put(end,degree.getOrDefault(end,0)-1);

        }

        List<Integer> res = new ArrayList<>();

        int stNode = pairs[0][0];
        for(int node:degree.keySet()){
            if(degree.get(node) == 1){
                stNode = node;
                break;
            }
        }
       
        dfs(graph,stNode,res);
        Collections.reverse(res);
        int[][] ans = new int[pairs.length][2];
        for(int i = 0;i<res.size()-1;i++){
            ans[i][0] = res.get(i);
            ans[i][1] = res.get(i+1);
        }
        return ans;
    }

    void dfs(Map<Integer, List<Integer>> graph,int node,List<Integer> res){
        List<Integer> arr = graph.getOrDefault(node,new ArrayList<>());
        while(!arr.isEmpty()){
            int next = arr.remove(0);
            dfs(graph,next,res);

        }
        res.add(node);

    }
}