class Solution {
    public int largestIsland(int[][] grid) {
        int cnt = 2;
        int n = grid.length;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                if(grid[i][j] == 1){
                    dfs(n,grid,i,j,cnt);
                    cnt++;
                }
            }
        }
        Map<Integer,Integer> map = new HashMap<>();
        int max = 0;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                if(grid[i][j] != 0){
                    map.put(grid[i][j],map.getOrDefault(grid[i][j],0)+1);
                    max = Math.max(max,map.get(grid[i][j]));
                }
            }
        }
        
        for(int r = 0;r<n;r++){
            for(int c = 0;c <n;c++){
                if(grid[r][c] == 0){
                    max = Math.max(max,sum(map,grid,r,c,n));
                }
            }
        }
        // System.out.println(map);
        // for(int[] i:grid){
        //     System.out.println(Arrays.toString(i));
        // }
        return max;
    }

    int sum(Map<Integer,Integer> map,int[][] grid,int r,int c,int n){
        int s = 1;
        int[] adjrow = {-1,1,0,0};
        int[] adjcol = {0,0,-1,1};
        Set<Integer> set = new HashSet<>();
        for(int i = 0;i<4;i++){
            int nrow = r+adjrow[i];
            int ncol = c+adjcol[i];
            if(nrow >=0 && nrow < n && ncol >= 0 && ncol < n && grid[nrow][ncol] != 0){
              if(!set.contains(grid[nrow][ncol])){
                s+=map.get(grid[nrow][ncol]);
                set.add(grid[nrow][ncol]);
              }  
            }
        }
        return s;
    }

    public void dfs(int n,int[][] grid,int r,int c,int cnt){
        if(r < 0 || c < 0 || c >= n || r >= n || grid[r][c] != 1){
            return;
        }
        
        grid[r][c] = cnt;

        dfs(n,grid,r-1,c,cnt);
        dfs(n,grid,r,c-1,cnt);
        dfs(n,grid,r+1,c,cnt);
        dfs(n,grid,r,c+1,cnt);
    }



}