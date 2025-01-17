class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        long sum = 0;
        int max = piles[0];
        for(int i:piles){
            sum+=i;
            max = Math.max(max,i);
        }
        int min = ceil(sum,h);
        int ans = max;
        while(min < max){
            int mid = (min+max)/2;
            if(calculateHour(piles,mid) <= h){
                ans = mid;
                max = mid;
            }else{
                min = mid+1;
            }

        }
        return ans;
    }

    int calculateHour(int[] piles,int h){
        int hours = 0;
        for(int i:piles){
            hours += ceil(i,h);
        }
        return hours;
    }
    int ceil(long sum,int h){
        int min = (int)(sum/h);
        if(sum%h == 0){
            return min;
        }
        return min+1;
    }
}