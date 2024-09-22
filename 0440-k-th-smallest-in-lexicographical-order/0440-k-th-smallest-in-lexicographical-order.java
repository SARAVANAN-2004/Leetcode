class Solution {
    public int findKthNumber(int n, int k) {
        int i = 1;
        int cur = 1;
        while( i < k){
            int steps = count(cur,n);
            if(steps+i <= k){
                cur++;
                i+=steps;
            }else{
                i++;
                cur *= 10;
            }
        }
        return cur;
    }
    int count(long cur,int n){
        int steps = 0;
        long neighbor = cur+1;
        while(cur <= n){
            neighbor = Math.min((long)n+1,neighbor);
            steps += neighbor -  cur;
            cur *= 10;
            neighbor *= 10;
        }
        return steps;
    }
}