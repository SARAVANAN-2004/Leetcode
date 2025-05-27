class Solution {
    public String decodeString(String s) {
        Stack<Character> stk = new Stack<>();
        // StringBuilder sb = new StringBuilder();
        
        for(char ch: s.toCharArray()){
           if(stk.isEmpty() || ch != ']'){
            stk.push(ch);
           }else{
                String a = "";
                while(stk.peek() != '['){
                    a = stk.pop()+a;
                }
                stk.pop();
                String num = "";
                while(!stk.isEmpty() && Character.isDigit(stk.peek())){
                    num = stk.pop()+num;
                }
                int n = Integer.valueOf(num);
                StringBuilder sb = new StringBuilder();
                for(int i = 0;i<n;i++){
                    sb.append(a);
                }
                // System.out.println(sb);
                for(char c:sb.toString().toCharArray()){
                    stk.push(c);
                }
           }
        }
        StringBuilder sb = new StringBuilder();
        for(char ch:stk) sb.append(ch);
        return sb.toString();
    }
}