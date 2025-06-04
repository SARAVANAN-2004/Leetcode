class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) return false;
        return solve(s,t) && solve(t,s);
    }

    boolean solve(String s,String t){
        Map<Character,Character> map1 = new HashMap<>();
        
        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            char ch1 = t.charAt(i);
            if(map1.containsKey(ch) && map1.get(ch) != ch1){
                return false;
            }else{
                map1.put(ch,ch1);
            }
        }
        return true;
    }
}