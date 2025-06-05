class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        int[] map = new int[26];
        List<List<Character>> adj = new ArrayList<>();
        int cnt = 1;
        adj.add(new ArrayList<>());
        for(int i = 0;i<s1.length();i++){
            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(i);
            int x = ch1 - 'a', y = ch2 -'a';
            if(map[x] == map[y] && map[x] != 0){
                continue;
            }else if((map[x] == 0 && map[y] != 0) || (map[y] == 0 && map[x] !=0)){
                if(map[x] != 0){
                    map[y] = map[x];
                    // System.out.println(map[x]-1);
                    // System.out.println(Arrays.toString(map));
                    // for(List<Character> a:adj){
                    //     System.out.println(a);
                    // }
                    adj.get(map[x]-1).add(ch2);
                }else{
                    map[x] = map[y];
                    adj.get(map[y]-1).add(ch1);
                }
            }else if(map[x] == 0 && map[y] == 0){
                cnt++;
                map[x] =cnt;
                map[y] = cnt;
                adj.add(new ArrayList<>());
                adj.get(cnt-1).add(ch1);
                adj.get(cnt-1).add(ch2);
            }else{
                if(adj.get(map[x]-1).size() <= adj.get(map[y]-1).size()){
                    adj.get(map[y]-1).addAll(new ArrayList<>(adj.get(map[x]-1)));
                    int val = map[x];
                    solve(adj,map[x],map[y],map);
                    // System.out.println(adj.get(map[y]-1));
                    // System.out.println(adj.get(map[y]-1));
                    
                    // adj.remove(val-1);
                }else{
                    adj.get(map[x]-1).addAll(new ArrayList<>(adj.get(map[y]-1)));
                    // System.out.println("this");
                    int val = map[y];
                    solve(adj,map[y],map[x],map);
                    // adj.remove(val-1);
                }
            }
        }
        // System.out.println(Arrays.toString(map));
        // for(List<Character> a:adj){
        //     System.out.println(a);
        // }
        Map<Integer,Character> arr  = new HashMap<>();
        for(int i = 0;i<26;i++){
            if(map[i] != 0 && !arr.containsKey(map[i])){
                arr.put(map[i],(char)(i+'a'));
            }
        }
        // System.out.println(arr);
        StringBuilder sb = new StringBuilder();
        for(char ch:baseStr.toCharArray()){
            if(map[ch-'a'] == 0){
                sb.append(ch);
            }else{
                sb.append(arr.get(map[ch-'a']));
            }
        }
        // return baseStr;
        return sb.toString();
    }

    void solve(List<List<Character>> adj,int st,int des,int[] map){
        // int val = map[des];
        // System.out.println("val "+des);
        for(char ch :adj.get(st-1)){
            map[ch-'a'] =des;
        }
    }
}