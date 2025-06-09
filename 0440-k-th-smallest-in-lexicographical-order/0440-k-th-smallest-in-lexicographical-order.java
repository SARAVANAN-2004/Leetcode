class Solution {
    public int findKthNumber(int n, int k) {
        int cur = 1;
        int i = 1;
        while(i < k){
            int step = count(cur,n);

            if(step +i <= k){
                i+=step;
                cur++;
            }else{
                cur *= 10;
                i++;
            }
        }
        return cur;
    }

    int count(long cur,int n){
        int  res = 0;
        long nei = cur+1;
        while(cur <= n){
            nei = Math.min(nei,(long)n+1);
            res += nei - cur;
            cur *= 10;
            nei *= 10;
        }
        return res;
    }
}