class Solution {
    public List<Integer> lexicalOrder(int n) {
        String[] s = new String[n];
        TreeMap<String,Integer> map = new TreeMap<>();
        List<Integer> ans = new ArrayList<>();
        for(int i  = 0;i<n;i++){
            s[i] = (i+1)+"";
            map.put(s[i],i+1);
        }
        for(String a:map.keySet()){
            ans.add(map.get(a));
        }
        return ans;

    }
}