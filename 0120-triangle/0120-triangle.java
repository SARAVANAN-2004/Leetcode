class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.size() == 1) return triangle.get(0).get(0);
        int m = triangle.size();
        int n = triangle.get(triangle.size()-1).size();
        int [][] dp= new int[m][n];
        for(int i=0; i<m; i++){
            Arrays.fill(dp[i], -1);
        }
        return findMinPath(triangle, 0, 0, dp);
    }

    public int findMinPath(List<List<Integer>> triangle, int index, int col, int[][] dp){
        if(index == triangle.size()-1){
            return triangle.get(index).get(col);
        }
        if(index >= triangle.size()|| col >= triangle.get(index).size()){
            return (int) 1e9;
        }

        if(dp[index][col] != -1) return dp[index][col];

        int sum1 = triangle.get(index).get(col) + findMinPath(triangle, index+1, col, dp);
        int sum2 = triangle.get(index).get(col) + findMinPath(triangle, index+1, col+1, dp);
        return dp[index][col]=Math.min(sum1, sum2);
    }
}