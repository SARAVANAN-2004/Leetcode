class Solution {
    public int minFlips(int[][] mat) {
        Queue<Integer> que = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        String  s = "";
        int row = mat.length;
        int col = mat[0].length;
        for(int r = 0;r<row;r++){
            for(int c = 0;c<col;c++){
                s += mat[r][c];
            }
        }
        que.add(Integer.parseInt(s,2));
        boolean[] vis = new boolean[(1 << (row * col))];
        vis[Integer.parseInt(s,2)] = true;
        // System.out.println(set);
        int step = 0;

        int [][] adj = new int[][]{
            {0,-1},{0,1},{1,0},{-1,0},{0,0}
        };
        while(!que.isEmpty()){
            int size = que.size();
            for(int i  = 0;i<size;i++){
                int cur = que.poll();
                if(cur == 0) return step;
                for(int x = 0;x<row * col;x++){
                    int r = x / col, c = x%col;
                    int temp = cur;
                    for(int j = 0;j<5;j++){
                        
                        int ar = r+adj[j][0] , ac= c + adj[j][1];
                        if(ar < 0 || ac < 0 || ar >= row || ac >= col) continue;
                        int k = ar * col + ac;
                        temp = temp ^ (1 << k);
                        
                    }
                    if(!vis[temp]){
                        // System.out.println(cur+" "+temp+" "+x+" "+Integer.toBinaryString(cur)+" "+Integer.toBinaryString(temp));
                        que.add(temp);
                        vis[temp] = true;
                    }
                }
            }
            // System.out.println(que);
            step++;
        }

        return -1;
    }
}