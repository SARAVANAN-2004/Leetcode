class Solution {
    public int minOperations(int[] nums, int[] numsDivide) {
        int gcd = numsDivide[0];
        for(int i = 1;i<numsDivide.length;i++){
            gcd = solve(gcd,numsDivide[i]);
        }
        Arrays.sort(nums);
        int cnt = 0;
        for(int i:nums){
            if(gcd%i == 0){
                return cnt;
            }
            cnt++;
        }
        return -1;

    }
    int solve(int a,int b){
        if(b == 0){
            return a;
        }
        return solve(b,a%b);
    }
}