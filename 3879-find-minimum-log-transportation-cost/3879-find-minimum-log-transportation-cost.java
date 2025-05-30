class Solution {
    public long minCuttingCost(int n, int m, int k) {
        long cost = 0;
        if(n >k){
           cost = (long)(n - k)*k;
           return cost;
        }
        else if(m > k){
            cost = (long)(m - k)*k;
        //    System.out.println(cost);
           return cost;
        }
        return 0;
        
    }
    
    
    
}