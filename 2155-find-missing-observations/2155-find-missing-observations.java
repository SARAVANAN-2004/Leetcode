class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        int sum = (m+n)*mean;
        for(int i:rolls){
            sum -= i;
        }
        if(sum < n || (n*6)< sum){
            return new int[]{};
        }
        int[] ans = new int[n];
        int base = sum/n;
        Arrays.fill(ans,base);
        sum %= n;
        for(int i = 0;i<n && sum != 0;i++){
            if(sum + ans[i] <= 6){
                ans[i] += sum;
                break;
            }else{
                ans[i]  = 6;
                sum -= (6 - (base));
            }
        }
        return ans;
    }
}