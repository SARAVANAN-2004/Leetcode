class Solution {
    public List<Integer> lexicalOrder(int n) {
        TreeMap<String,Integer> map = new TreeMap<>();
        List<Integer> ans = new ArrayList<>();
        for(int i  = 0;i<n;i++){
            String a = (i+1)+"";
            map.put(a,i+1);
        }
        for(String a:map.keySet()){
            ans.add(map.get(a));
        }
        return ans;

    }
}