class Solution {
    class Pair{
        String s;
        double val;
        public Pair(String s,double val){
            this.s = s;
            this.val = val;
        }
    }
    Map<String,List<Pair>> map;
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        map =  new HashMap<>();
        for(int i = 0;i<values.length;i++){
            List<String> adj = equations.get(i);
            double val = values[i];
            Pair pair1 = new Pair(adj.get(1),val);
            Pair pair2 = new Pair(adj.get(0),1/val);
            map.computeIfAbsent(adj.get(0),k->new ArrayList<>()).add(pair1);
            map.computeIfAbsent(adj.get(1),k->new ArrayList<>()).add(pair2);
        }
        // for(String s:map.keySet()){
        //     System.out.println(s);
        //     for(Pair pair: map.get(s)){
        //         System.out.println(pair.s+" "+pair.val);
        //     }
        // }
        double[] ans = new double[queries.size()];
        for(int i = 0;i<queries.size();i++){
            List<String> adj = queries.get(i);
            if(!map.containsKey(adj.get(0)) || !map.containsKey(adj.get(1))){
            ans[i] = -1;
            }else{
            ans[i] = solve(adj.get(0),adj.get(1));
            }
        }

        return ans;
    }

    double solve(String src,String des){
        

        Queue<Pair> que = new LinkedList<>();
        Set<String> vis = new HashSet<>();
        vis.add(src);
        que.add(new Pair(src,1));
        while(!que.isEmpty()){
            Pair cur = que.poll();
            if(cur.s.equals(des)) return cur.val;
            for(Pair adj :map.get(cur.s)){
                if(!vis.contains(adj.s)){
                    vis.add(adj.s);
                    que.add(new Pair(adj.s,cur.val * adj.val));
                }
            }
        }

        return -1;

    }
}