class Solution {
    public int shortestPathAllKeys(String[] grid) {
        int row = grid.length, col = grid[0].length();
        char[][] arr = new char[row][col];
        int key = 0, cnt = 0;
        Queue<int[]> que = new LinkedList<>();
        boolean [][][] vis = new boolean[row][col][(1<<6)];
        for(int r = 0;r<row;r++){
            for(int c = 0;c<col;c++){
                char ch = grid[r].charAt(c);
                if(ch == '@'){
                    que.add(new int[]{r,c,0,0});
                    vis[r][c][0] = true;
                    arr[r][c] = '.';
                }else{
                    if(Character.isLowerCase(ch)){
                        cnt++;
                    }
                    arr[r][c] = ch;
                }
                
            }
        }
        
        key = (1 << cnt)-1;
        // System.out.println(cnt+" "+key);
        int[][] adj = new int[][]{
            {0,1}, {0,-1},{1,0},{-1,0}
        };
        while(!que.isEmpty()){
            int[] cur =que.poll();
            int flag = cur[3];
            for(int i = 0;i<4;i++){
                int r = cur[0]+adj[i][0];
                int c = cur[1] + adj[i][1];
                if(r < 0 || c < 0 || r >= row || c >= col || arr[r][c] == '#'){
                    continue;
                }
                char ch = arr[r][c];
                if(ch >= 'A' && ch <= 'Z'){
                    if((flag & (1 << (ch - 'A'))) == 0){
                        continue;
                    }
                }
                int newFlag = flag;
                if(ch >= 'a' && ch <= 'f'){
                     newFlag = flag | (1 << ch-'a');
                }
                
                if(newFlag == key) return cur[2]+1;
                if(!vis[r][c][newFlag]){
                    que.add(new int[]{r,c,cur[2]+1,newFlag});
                    vis[r][c][newFlag] = true;
                }
            }
        }
        return -1;
    }
}