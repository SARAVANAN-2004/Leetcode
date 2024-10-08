class Solution {
    public int minSwaps(String s) {

        
        Stack<Character> stack = new Stack<>();
        for(char ch:s.toCharArray()){
            if(stack.isEmpty()){
                stack.push(ch);
            }else if(stack.peek() == '[' && ch == ']'){
                stack.pop();
            }else{
                stack.push(ch);
            }
            
        }

        return ((stack.size()/2)+1)/2;
    }
}