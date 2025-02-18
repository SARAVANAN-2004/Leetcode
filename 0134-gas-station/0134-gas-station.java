class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int st = 0;
        long sum = 0;
        long maxi = 0;
        int n = gas.length;
        int[] arr = new int[n];
        for(int i = 0;i<n;i++){
            arr[i] = gas[i] - cost[i];
            sum += arr[i];
        }
        if(sum < 0) return -1;
        for(int i = 0;i<n;i++){
            if(arr[i] > arr[i]+ maxi){
                st = i;
                maxi = arr[i];
            }else{
                maxi += arr[i];
            }
        }
        return st;

    }
}