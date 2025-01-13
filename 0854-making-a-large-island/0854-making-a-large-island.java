class Solution {
    int size = 0;
    int cnt = 2;
    int row,col;
    public int largestIsland(int[][] grid) {
        row = grid.length;
        col = grid[0].length;
        Map<Integer,Integer> map = new HashMap<>();
        int maxi = 1;
        for(int r = 0;r<row;r++){
            for(int c = 0;c<col;c++){
                if(grid[r][c] == 1){
                    dfs(r,c,grid);
                    map.put(cnt,size);
                    maxi = Math.max(size,maxi);
                    size = 0;
                    cnt++;
                }
            }
        }
        
        for(int r = 0;r<row;r++){
            int[] adjr = new int[]{-1,1,0,0};
            int[] adjc = new int[]{0,0,1,-1};
            for(int c = 0;c<col;c++){
                if(grid[r][c] == 0){
                    int val = 1;
                    Set<Integer> set = new HashSet<>();
                    for(int i = 0;i<4;i++){
                        int ro = adjr[i] + r, co = adjc[i]+ c;
                        if(valid(ro,co) && grid[ro][co] != 0 && 
                        !set.contains(grid[ro][co])){
                            val += map.get(grid[ro][co]);
                            set.add(grid[ro][co]);
                        }
                    }
                    maxi = Math.max(maxi,val);

                }
            }
            
        }
        return maxi;
    }

    public void dfs(int r,int c,int [][]grid){
        if(!valid(r,c) || grid[r][c] != 1){
            return;
        }
        size++;
        grid[r][c] = cnt;
        dfs(r-1,c,grid);
        dfs(r+1,c,grid);
        dfs(r,c-1,grid);
        dfs(r,c+1,grid);
    }
    public boolean valid(int r,int c){
        return r >=0 && r < row && c >= 0 && c<col;
    }
}