class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int end = n*n;
        int[] map = new int[end+1];

        int idx = 1;
        boolean ltor = true;
        for(int r = n-1;r>=0;r--){
            if(ltor){
            for(int c = 0;c<n;c++){
                map[idx++] = board[r][c];
            }
            ltor = false;
            }
            else{
                for(int c = n-1;c>= 0;c--){
                map[idx++] = board[r][c];

                }
                ltor = true;
            }
        }

       
        boolean[] vis = new boolean[end+1];

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{1,0});
        vis[1] = true;
        int min = Integer.MAX_VALUE;
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int num = cur[0] ,roll = cur[1];
            
            for(int curr = num+1;curr<=Math.min(num+6,end);curr++){
                
                int place = curr;
                if(map[curr] != -1){
                    place = map[curr];
                }
                if(place == end){
                    min = Math.min(min,roll+1);
                    continue;
                }
                
                if(!vis[place]){
                    vis[place]  = true;
                    queue.add(new int[]{place,roll+1});
                }
            }

        }

        return min == Integer.MAX_VALUE?-1:min;
    }
}