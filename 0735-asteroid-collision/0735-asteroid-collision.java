class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for(int n :asteroids){
            if(!stack.isEmpty() && stack.peek() > 0 && n < 0){
                boolean add = true;
                while(!stack.isEmpty() && stack.peek() > 0 && n < 0){
                    if(stack.peek() == Math.abs(n)){
                        stack.pop();
                        add = false;
                        break;
                    }else if(stack.peek() > Math.abs(n)){
                        add = false;
                        break;
                    }else{
                        stack.pop();
                    }
                }

                if(add){
                    stack.push(n);
                }
            }else{
                stack.push(n);
            }
        }
        int[] res = new int[stack.size()];
        int i = stack.size() - 1;
        while(!stack.isEmpty()){
            res[i--] = stack.pop();
        }
        return res;
    }
}