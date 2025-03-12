class Solution {
    public int snakesAndLadders(int[][] board) {
        Map<Integer,Integer> map = new HashMap<>();
        int n = board.length;
        int end = n*n;
        int idx = 1;
        boolean ltor = true;
        for(int r = n-1;r>=0;r--){
            if(ltor){
            for(int c = 0;c<n;c++){
                map.put(idx++,board[r][c]);
            }
            ltor = false;
            }
            else{
                for(int c = n-1;c>= 0;c--){
                map.put(idx++,board[r][c]);
                }
                ltor = true;
            }
        }

        // System.out.println(map);
        Set<Integer> set = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{1,0});
        set.add(1);
        int min = Integer.MAX_VALUE;
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int num = cur[0] ,roll = cur[1];
            
            for(int curr = num+1;curr<=Math.min(num+6,end);curr++){
                // if(curr == end){
                //     min = Math.min(min,roll+1);
                //     continue;
                // }
                int place = curr;
                if(map.get(curr) != -1){
                    place = map.get(curr);
                }
                if(place == end){
                    min = Math.min(min,roll+1);
                    continue;
                }
                
                if(!set.contains(place)){
                    // set.add(curr);
                    set.add(place);
                    queue.add(new int[]{place,roll+1});
                }
            }

        }

        return min == Integer.MAX_VALUE?-1:min;
    }
}