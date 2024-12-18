class Solution {
    public int[] finalPrices(int[] price) {
        
        int[] res = price.clone();
        Stack<Integer> stack = new Stack<>();
        int n = price.length;
        for(int i = 0;i < n;i++){
            while(!stack.isEmpty() && price[stack.peek()] >= price[i]){
                res[stack.pop()] -= price[i];
            }
            stack.add(i);
        }
        return res;

    }
}