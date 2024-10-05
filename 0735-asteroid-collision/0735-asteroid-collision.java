class Solution {
    public int[] asteroidCollision(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        for(int i:arr){
            if(stack.isEmpty() || valid(stack.peek(),i,stack)){
                stack.push(i);
            }else{
                collision(stack,i);
            }
            
        }

        int[] ans = new int[stack.size()];
        for(int i = stack.size()-1;i>=0 ;i--){
            ans[i] = stack.pop();
        }
        return ans;
    }
    void collision(Stack<Integer> stack,int cur){

        while(!stack.isEmpty() && !valid(stack.peek(),cur,stack)){
            int ans = cur+stack.peek();
            if(ans == 0){
                stack.pop();
                return;
            }
            if(ans > 0){
                return;
            }else{
                stack.pop();
            }
        }
        if(stack.isEmpty() || valid(stack.peek(),cur,stack)){
            stack.push(cur);
        }
    }

    boolean valid(int a,int b,Stack<Integer> stack){
        if(!stack.isEmpty() && (a>0 && b < 0)) return false;
        return true;
    }
}