class Solution {
    class Pair{
        String s;
        double val;
        public Pair(String s,double val){
            this.s = s;
            this.val = val;
        }
    }
    Set<String> vis;
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
            vis = new HashSet<>();
            ans[i] = solve(adj.get(0),adj.get(1),1);
            }
        }

        return ans;
    }

    double solve(String cur,String des,double product){
            if(cur.equals(des)){
                return product;
            }
            for(Pair adj :map.get(cur)){
                if(!vis.contains(adj.s)){
                    vis.add(adj.s);
                    double val  = solve(adj.s,des,product * adj.val);
                    if(val != -1) return val;
                }
            }
        

        return -1;

    }
}