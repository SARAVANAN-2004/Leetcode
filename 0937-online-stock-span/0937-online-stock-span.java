class StockSpanner {
    Stack<int[]> stk = new Stack<>();
    public StockSpanner() {
        
    }
    
    public int next(int price) {
        
        int sum = 1;
        while(!stk.isEmpty() && stk.peek()[0] <= price){
            sum += stk.pop()[1];
        }
        stk.push(new int[]{price,sum});
        return sum;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */