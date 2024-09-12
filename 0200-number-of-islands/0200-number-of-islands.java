class Solution {
    public int numIslands(char[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int cnt = 0;
        for(int i = 0;i<r;i++){
            for(int j = 0;j<c;j++){
                if(grid[i][j] == '1'){
                    cnt++;
                    dfs(grid,i,j,r,c);
             }
            }
        }
        return cnt;
    }
    void dfs(char[][] grid,int i,int j,int row,int col){
        if(i<0 || i>=row || j<0 || j>=col || grid[i][j] != '1'){
            return;
        }
        grid[i][j] = '2';
        dfs(grid,i-1,j,row,col);
        dfs(grid,i,j+1,row,col);
        dfs(grid,i+1,j,row,col);
        dfs(grid,i,j-1,row,col); 
    }
}