class Solution {
    public int countSquares(int[][] arr) {
        int row = arr.length;
        int col = arr[0].length;
        int sum = 0;
        for(int r = 1;r <row;r++){
            for(int c = 1;c<col;c++){

                if(arr[r][c] == 1 && arr[r-1][c-1] != 0 && arr[r-1][c] != 0 && arr[r][c-1] != 0){
                    arr[r][c] = Math.min(arr[r-1][c-1],Math.min(arr[r][c-1],arr[r-1][c]))+1; 
                }
               
            }
        }
        for(int i = 0;i<row;i++){
            for(int j = 0;j<col;j++){
                sum+=arr[i][j];
            }
        }

        // for(int[] i:arr){
        //     System.out.println(Arrays.toString(i));
        // }
        return sum;
    }
}