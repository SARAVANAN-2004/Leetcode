class Solution {
    public int minAddToMakeValid(String s) {
        if(s.length() == 0){return 0;}
        Stack<Character> stack = new Stack<>();
        for(char ch:s.toCharArray()){
            if(stack.isEmpty()){
                stack.push(ch);
            }else if(stack.peek() == '(' && ch == ')'){
                stack.pop();
            }else{
                stack.push(ch);
            }
        }
        return stack.size();
    }
}