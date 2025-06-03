class Solution {
    public int[] dailyTemperatures(int[] temp) {
        int n = temp.length;
        int[] ans = new int[n];
        Stack<int[]> stk = new Stack<>();
        for(int i = n-1;i>=0;i--){
            int t = temp[i];

            int sum = 0;
            while(!stk.isEmpty() && stk.peek()[0] <= t){
                sum += stk.peek()[1];
                stk.pop();
            }
            if(stk.isEmpty()){
                temp[i] = 0;
            }else{
                temp[i] = sum+1;
            }
            stk.push(new int[]{t,temp[i]});
        }
        return temp;
    }
}