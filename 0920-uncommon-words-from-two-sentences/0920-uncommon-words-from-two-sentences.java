class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        Map<String,Integer> map1 = new HashMap<>();
        Map<String,Integer> map2 = new HashMap<>();
        for(String s:s1.split(" ")){
            map1.put(s,map1.getOrDefault(s,0)+1);
        }
        for(String s:s2.split(" ")){
            map2.put(s,map2.getOrDefault(s,0)+1);
        }
        List<String> ans = new ArrayList<>();
        for(String s:s1.split(" ")){
            int cnt = map1.get(s);
            if(cnt == 1 && !map2.containsKey(s)){
                ans.add(s);
            }
        }
        for(String s:s2.split(" ")){
            int cnt = map2.get(s);
            if(cnt == 1 && !map1.containsKey(s)){
                ans.add(s);
            }
        }
        return ans.toArray(new String[0]);
        // String[] res = new String[ans.size()];
        // for(int i = 0;i < ans.size();i++){
        //     res[i] = ans.get(i);
        // }
        // return res;

    }
}