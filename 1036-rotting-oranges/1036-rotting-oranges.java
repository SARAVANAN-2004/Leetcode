class Solution {
    public int orangesRotting(int[][] grid) {
        int fresh = 0;
        int min  = 0;
        Queue<int[]> queue = new LinkedList<>();
        int row = grid.length , col = grid[0].length;
        for(int i = 0;i<row;i++){
            for(int j = 0;j<col;j++){
                if(grid[i][j] == 1){
                    fresh++;
                }
                else if(grid[i][j] == 2){
                    queue.add(new int[]{i,j});
                }
            }
        }
        int[][] adj = new int[][]{
            {-1,0},
            {1,0},
            {0,1},
            {0,-1}
        };
        while(!queue.isEmpty() && fresh != 0){
            int size = queue.size();
            System.out.println(size);
            for(int i = 0;i<size;i++){
                int[] cur = queue.poll();
                int r = cur[0];
                int c = cur[1];
                for(int j = 0;j<4;j++){
                    int curR = r+adj[j][0];
                    int curC = c+adj[j][1];
                    if(valid(curR,curC,row,col,grid)){
                        grid[curR][curC] = 2;
                        fresh--;
                        queue.add(new int[]{curR,curC});
                    }
                }

            }
            min++;
        }

        return fresh == 0 ? min : -1;
    }

    boolean valid(int r,int c,int row,int col,int[][] grid){
        return r >= 0 && r<row && c >= 0 && c<col && grid[r][c] == 1;
    }
}