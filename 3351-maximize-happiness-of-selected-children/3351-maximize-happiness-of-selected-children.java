class Solution {
    public long maximumHappinessSum(int[] hap, int k) {
        Arrays.sort(hap);
        int j = 0;
        long sm = 0;
        for(int i = hap.length-1;i>=0;i--){
            if(k == 0 || hap[i]-j <= 0 ){
                return sm;
            }
            sm += hap[i]-j;
            j++;
            k--;
        }
        return sm;
    }
}