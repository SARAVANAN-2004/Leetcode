class Solution {
    public int maxSum(int[][] arr) {
        int sum = Integer.MIN_VALUE;
        int r = arr.length;
        int c = arr[0].length;
        for (int i  = 0; i < r-2 ; i++) {
            for (int j = 0; j < c - 2; j++) {
                int ans = arr[i][j]+arr[i][j+1]+arr[i][j+2]+arr[i+1][j+1]+arr[i+2][j]+arr[i+2][j+1]+arr[i+2][j+2];
                sum = Math.max(ans,sum);
            }
        }
        return sum;
    }
}