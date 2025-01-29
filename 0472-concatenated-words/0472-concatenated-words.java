class Solution {
    Set<String> set;
    Map<String,Boolean> map;
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        set = new HashSet<>();
        for(String s:words) set.add(s);
        map = new HashMap<>();
        List<String> res = new ArrayList<>();
        for(String s:words){
            if(dfs(s)){
                res.add(s);
            }
        }
        return res;

    }

    boolean dfs(String s){
        if(map.containsKey(s)){
            return map.get(s);
        }

        for(int i = 1;i<s.length();i++){
            String pre = s.substring(0,i);
            String suf = s.substring(i);

            if(set.contains(pre) && (set.contains(suf) || dfs(suf))){
                map.put(s,true);
                return true;
            }
        }
        map.put(s,false);
        return false;
    }
}