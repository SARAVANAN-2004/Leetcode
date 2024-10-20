class Solution {
    public boolean parseBoolExpr(String s) {
        int n = s.length();
        Stack<Character> st = new Stack<>();
        
        for(int j=0; j<n; j++){
            char ch = s.charAt(j);

            if(ch==')'){
                HashSet<Character> hp = new HashSet<>();
                while(st.peek()!='('){
                    hp.add(st.pop());
                }
                st.pop();
                char op = st.pop();
                if(op=='!'){
                    st.push(hp.contains('t') ? 'f' : 't');
                }else if(op=='&'){
                    st.push(hp.contains('f') ? 'f' : 't');
                }else{
                    st.push(hp.contains('t') ? 't' : 'f');
                }
            }else if(ch!=','){
                st.push(ch);
            }
        }
        return st.peek()=='t' ? true : false;
    }
}