class Solution {
    public int minimumObstacles(int[][] grid) {

        int[][] dir = new int[][]{
            {0,1},
            {0,-1},
            {1,0},
            {-1,0},
        };
        int m = grid.length;
        int n = grid[0].length;

        int[][] arr = new int[m][n];

        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                arr[i][j] = Integer.MAX_VALUE;
            }
        }
        arr[0][0] = grid[0][0];

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[0] - b[0]);
        pq.add(new int[]{arr[0][0],0,0});
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            if(cur[1] == m-1 && cur[2] == n-1){
                return arr[m-1][n-1];
            }


            for(int[] d:dir){
                int newRow = cur[1]+d[0], newCol = cur[2]+d[1];
                if(isvalid(newRow,newCol,m,n)){
                    int Obstacle = cur[0]+grid[newRow][newCol];

                    if(Obstacle < arr[newRow][newCol]){
                        arr[newRow][newCol] = Obstacle;
                        pq.add(new int[]{Obstacle,newRow,newCol});
                    }
                }
            }

        }

        
        return arr[m-1][n-1];
    }
    boolean isvalid(int r,int c,int m,int n){
            return (r >= 0 && c >= 0 && r<m && c < n);
        }
}