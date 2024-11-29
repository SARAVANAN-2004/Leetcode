class Solution {

    public int minimumTime(int[][] grid) {
        if(Math.min(grid[0][1],grid[1][0]) > 1){
            return -1;
        }
        int[][] dir = new int[][]{
            {0,1},
            {0,-1},
            {1,0},
            {-1,0},
        };
        int m = grid.length, n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[0] - b[0]);
        
        pq.add(new int[]{0,0,0});
        
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int t = cur[0];
            int r = cur[1] , c = cur[2];

            if( r == m-1 && c == n-1){
                return t;
            }

            if(vis[r][c]){
                continue;
            }
            vis[r][c] = true;
            for(int[] d:dir){
                int nr = r+d[0],nc = c+d[1];
                int wait = 0;
                if(isvalid(nr,nc,m,n) && !vis[nr][nc]){
                    if(Math.abs(grid[nr][nc] - t)%2 == 0){
                        wait = 1;
                    }
                    int nxt_t = Math.max(grid[nr][nc]+wait,t+1);
                    
                    pq.add(new int[] {nxt_t,nr,nc});
                }
            }
        }

        return -1;
    }
    boolean isvalid(int r,int c,int m,int n){
        return (r>=0 && c >= 0 && r<m && c< n);
    }
}