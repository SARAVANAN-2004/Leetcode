class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int neg_cnt = 0;
        long sum = 0;
        int cnt = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int n = matrix.length;
        for(int i = 0;i<n;i++){
            for(int j =0;j<n;j++){
                
                if(matrix[i][j] < 0){
                    max =  Math.max(max,matrix[i][j]);
                    cnt++;
                    sum += (matrix[i][j] * -1);
                }else{
                    min = Math.min(min,matrix[i][j]);
                    sum+=matrix[i][j];
                }

            }
        }
        if(cnt%2==1){
            // System.out.println(min+" "+sum+" "+max);
            // System.out.println(cnt);
            int val = Math.min(min,max*-1);
            sum = sum - (2*val);
        }
        return sum;
    }
}