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
        Stack<Integer> stk = new Stack<>();
        stk.push(-1);
        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == ')' && s.charAt(stk.peek()) == '('){
                stk.pop();
            }else{
                stk.push(i);
            }
        }
        int max = 0;
        int prev = 0;
        for(int  i:stk){
            max  = Math.max(max,i-prev-1);
            prev = i;
        }
        return max;
    }
}