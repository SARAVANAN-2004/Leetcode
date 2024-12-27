class Solution {
    public int maxScoreSightseeingPair(int[] val) {
        
        int maxSpot = val[0]+0;
        int score = 0,n = val.length;
        for(int i = 1;i<n;i++){
            if(score < maxSpot + (val[i] - i)){
                score = maxSpot + (val[i] - i);
            }
            if(maxSpot < val[i]+i){
            maxSpot = val[i]+i;
            }
        }
        return score;
    }
}