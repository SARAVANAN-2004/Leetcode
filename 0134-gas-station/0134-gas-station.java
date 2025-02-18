class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int st = 0;
        long sum = 0;
        long maxi = 0;
        int n = gas.length;
        
        for(int i = 0;i<n;i++){
            int curval = gas[i] - cost[i];
            sum += curval;
            if(curval > curval+ maxi){
                st = i;
                maxi = curval;
            }else{
                maxi += curval;
            }
        }
        if(sum < 0) return -1;
        
        return st;

    }
}