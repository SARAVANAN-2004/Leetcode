class Solution {
    public String robotWithString(String s) {
        int[] map = new int[26];
        for(char ch:s.toCharArray()){
            map[ch-'a']++;
        }
        Stack<Character> stk = new Stack<>();
        StringBuilder p = new StringBuilder();
        int minIdx = 0;
        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            map[ch-'a']--;
            stk.push(ch);
            while(minIdx < 26 && map[minIdx] == 0){
                minIdx++;
            }
            while(!stk.isEmpty() && stk.peek() <= (char)(minIdx+'a')){
                p.append(stk.pop());
            }
        }
        while(!stk.isEmpty()) p.append(stk.pop());
        return p.toString();
    }
}