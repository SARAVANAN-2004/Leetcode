class Solution {
    public int maxProfit(int[] prices) {
        int price = 0;
        int cur = prices[0];
        for(int i :prices){
            if(i > cur){
                price += (i - cur);
                cur = i;
            }else{
                cur = Math.min(cur,i);
            }
            
        }
        return price;

    }
}