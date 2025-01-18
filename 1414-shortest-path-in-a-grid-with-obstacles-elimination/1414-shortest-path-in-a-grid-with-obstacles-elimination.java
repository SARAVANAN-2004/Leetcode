class Solution {
    public int shortestPath(int[][] grid, int k) {
        int x = grid.length;
        int y = grid[0].length;
        boolean[][][] vis = new boolean[x][y][k+1];
        Queue<int[]> que = new ArrayDeque<>();
        que.add(new int[]{0,0,0,k});
        while(!que.isEmpty()){
            int[] cur = que.poll();
            int r = cur[0], c = cur[1] , step = cur[2], obstacle_rem = cur[3];
            if(r == x-1 && c == y-1) return step;
            if(vis[r][c][obstacle_rem]) continue;
            vis[r][c][obstacle_rem] = true;
            int[] adjR = new int[]{1,-1,0,0};
            int[] adjC = new int[]{0,0,1,-1};
            for(int i = 0;i<4;i++){
                int row = r + adjR[i] , col = c + adjC[i];
                if(row < x && row >= 0 && col < y && col >= 0 && obstacle_rem - grid[row][col] >= 0 ){
                    que.add(new int[]{row,col,step+1,obstacle_rem - grid[row][col]});
                }
            }
        }
        return -1;
    }
}