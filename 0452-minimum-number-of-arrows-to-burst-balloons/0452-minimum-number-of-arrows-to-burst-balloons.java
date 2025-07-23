class Solution {
    public int findMinArrowShots(int[][] pairs) {
             if(pairs == null){
            return 0;
        }
        int c = 1;
         Arrays.sort(pairs, (p1, p2) -> Integer.compare(p1[1], p2[1]));

        int prev = pairs[0][1];

        for(int i=1; i<pairs.length; i++){
            if(prev <  pairs[i][0]){
                c++;
                prev = pairs[i][1];
            }
        }
        return c;
    }
}