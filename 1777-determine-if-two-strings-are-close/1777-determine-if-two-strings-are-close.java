class Solution {
    public boolean closeStrings(String word1, String word2) {
        if(word1.length() != word2.length()) return false;
        Set<Character> set = new HashSet<>();
        for (char c : word1.toCharArray()) {
            set.add(c);
        }
        for(char c:word2.toCharArray()){
            if(!set.contains(c)) return false;
        }
        Map<Integer,Integer> m1 =solve(word1);
        Map<Integer,Integer> m2 = solve(word2);
        Set<Integer> s1 = m1.keySet();
        Set<Integer> s2 = m2.keySet();
        for(int i:s1){
            if(!s2.contains(i) || m1.get(i) != m2.get(i)){
                return false;
            }
        }for(int i:s2){
            if(!s1.contains(i) || m1.get(i) != m2.get(i)){
                return false;
            }
        }

        return true;
    }

    Map<Integer,Integer> solve(String word1){
        int[] arr = new int[26];
        for(char ch :word1.toCharArray()){
            arr[ch-'a']++;
        }
        Map<Integer,Integer> map = new HashMap<>();
        for(int i:arr){
            if(i != 0){
                map.put(i,map.getOrDefault(i,0)+1);
            }
        }
        return map;
        
    }
}