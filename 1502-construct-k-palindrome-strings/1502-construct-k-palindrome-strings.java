class Solution {
    public boolean canConstruct(String s, int k) {
        Map<Character,Integer> map = new HashMap<>();
        for(char ch:s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }

        int odd = 0;
        for(char ch:map.keySet()){
            if(map.get(ch)%2 == 1){
                odd++;
            }
        }
        if(s.length() < k || odd > k){
            return false;
        } 
        return true;
    }
}