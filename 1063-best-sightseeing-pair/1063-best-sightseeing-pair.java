class Solution {
    public int maxScoreSightseeingPair(int[] val) {
        
        int maxSpot = val[0]+0;
        int score = 0,n = val.length;
        for(int i = 1;i<n;i++){
            score = Math.max(score,maxSpot + (val[i] - i));
            maxSpot = Math.max(maxSpot,val[i]+i);
        }
        return score;
    }
}