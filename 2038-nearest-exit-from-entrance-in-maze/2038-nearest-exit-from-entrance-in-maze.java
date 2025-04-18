class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        Queue<int[]> queue = new LinkedList<>();
        int row = maze.length, col = maze[0].length;
        // boolean[][] vis = new boolean[row][col];
        queue.add(new int[]{entrance[0],entrance[1],0});
        maze[entrance[0]][entrance[1]] = '+';
        int[][] adj = new int[][]{
                {-1,0},
                {1,0},
                {0,-1},
                {0,1}
            };
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int r = cur[0];
            int c = cur[1];
            int step = cur[2];
           
            
            for(int i = 0;i<4;i++){
                int curR = r + adj[i][0];
                int curC = c + adj[i][1];
                if(valid(curR,curC,row,col,maze)){

                    if(curR == 0 || curC == 0 || curR == row-1 || curC == col-1) return step+1;
                    maze[curR][curC] = '+';
                    queue.add(new int[]{curR,curC,step+1});
                }
            }

        }
        return -1;
    }

    boolean valid(int r,int c,int row,int col,char[][] maze){
        return r >= 0 && r < row && c >= 0 && c < col && maze[r][c] == '.';
    }
}