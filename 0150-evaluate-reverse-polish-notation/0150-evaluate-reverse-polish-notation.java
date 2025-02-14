class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String s:tokens){
            if(s.length()> 1){
                stack.push(Integer.valueOf(s));
                continue;
            }
            Character ch = s.charAt(0);
            if(Character.isDigit(ch)){
                stack.push((int)(ch - '0'));
            }else{
                
                int b = stack.pop() , a = stack.pop();
                switch(ch){
                    case '+':
                        stack.push(a+b);
                        break;
                    case '-':
                        stack.push(a-b);
                        break;
                    case '*':
                        stack.push(a*b);
                        break;
                    case '/':
                        stack.push(a/b);
                        break;
                }
            }
        }
        return stack.peek();
    }
}