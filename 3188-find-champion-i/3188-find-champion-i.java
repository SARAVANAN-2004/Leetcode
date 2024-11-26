class Solution {
    public int findChampion(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[] arr = new int[row];
        for(int i = 0;i<row;i++){
            for(int j = 0;j<col;j++){
                if(i!=j && grid[i][j] == 1){
                    arr[i]++;
                }
            }
        }
        
        int maxIdx = 0;
        int max = 0;
        for(int i = 0;i<row;i++){
            if(max < arr[i]){
                max = arr[i];
                maxIdx = i;
            }
        }
        return maxIdx;
    }
}