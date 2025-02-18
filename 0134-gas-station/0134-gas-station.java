class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int st = 0;   // Starting index
        int sum = 0;  // Total balance
        int maxi = 0; // Current fuel balance
        
        for (int i = 0; i < gas.length; i++) {
            int curval = gas[i] - cost[i]; 
            sum += curval; 
            maxi += curval;

            if (maxi < 0) { // If running sum goes negative, reset
                st = i + 1;  
                maxi = 0;    
            }
        }
        return (sum < 0) ? -1 : st;
    }
}
