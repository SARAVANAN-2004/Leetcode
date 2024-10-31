class Solution {
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Collections.sort(robot);
        Arrays.sort(factory,(a,b) -> a[0] - b[0]);
        List<Integer> facPositions = new ArrayList<>();
        for(int[] i:factory){
            for(int j = 0;j<i[1];j++){
                facPositions.add(i[0]);
            }
        }

        int robotsSize = robot.size();
        int factorySize = facPositions.size();

        long[][] dp = new long[robotsSize+1][factorySize+1];

        for(int i = 0;i<robotsSize;i++){
            dp[i][factorySize] = (long) 1e12;
        }
        for(int i = robotsSize-1 ; i>= 0;i--){
            for(int j = factorySize-1;j>=0;j--){
                long assing =Math.abs(robot.get(i) - facPositions.get(j)) + dp[i+1][j+1];
                long skip = dp[i][j+1];
                dp[i][j] = Math.min(assing,skip);
            }
        }

        return dp[0][0];
    }
}