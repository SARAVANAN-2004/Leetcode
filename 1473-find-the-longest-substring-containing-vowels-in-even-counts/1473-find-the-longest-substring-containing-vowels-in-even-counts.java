class Solution {
        static String vowel = "aeiou";
static Map<Character,Integer> char_map = new HashMap<>();
static {
    for(int i = 0; i < 5; i++){
        char_map.put(vowel.charAt(i), (int)Math.pow(2, i));
    }
}

    public int findTheLongestSubstring(String s) {
        
        Map<Integer,Integer> map = new HashMap<>();
        int sub = 0;
        int prexor = 0;
        map.put(0,-1);
        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            if(char_map.containsKey(ch)){
                prexor ^= char_map.get(ch);
            }
            if(!map.containsKey(prexor)){
                map.put(prexor,i);
            }else{
                sub = Math.max(sub,i - map.get(prexor));
            }
        }
        return sub;
    }
}