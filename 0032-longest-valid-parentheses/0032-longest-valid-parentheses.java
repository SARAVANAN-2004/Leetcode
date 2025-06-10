class Solution {
    class obj{
        int i;
        char ch;
        public obj(int i,char ch){
            this.ch = ch;
            this.i = i;
        }
    }
    public int longestValidParentheses(String s) {
        s = "*"+s+"*";
        Stack<obj> stk = new Stack<>();
        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == ')' && stk.peek().ch == '('){
                stk.pop();
            }else{
                stk.push(new obj(i,ch));
            }
        }
        int max = 0;
        int prev = 0;
        for(obj cur:stk){
            max  = Math.max(max,cur.i-prev-1);
            prev = cur.i;
        }
        return max;
    }
}