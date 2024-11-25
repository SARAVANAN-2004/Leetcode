class Solution {
    public int slidingPuzzle(int[][] board) {
        int[][] directions = new int[][]{
            {1,3},
            {0,2,4},
            {1,5},
            {0,4},
            {1,3,5},
            {2,4},
        };

        String target = "123450";
        StringBuilder start = new StringBuilder();

        for(int i = 0;i<2;i++){
            for(int j = 0;j<3;j++){
                start.append(board[i][j]);
            }
        }

        Set<String> visited =new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        visited.add(start.toString());
        queue.add(start.toString());

        int moves = 0;
        while(!queue.isEmpty()){
            int s = queue.size();
            while(s-- > 0){
                String cur = queue.poll();

                if(cur.equals(target)){
                    return moves;
                }

                int zero = cur.indexOf('0');
                for(int newPos:directions[zero]){
                    String next = swap(cur,zero,newPos);
                    if(visited.contains(next)) continue;

                    visited.add(next);
                    queue.add(next);
                }
            }
            moves++;
        }
        return -1;
    }

    String swap(String cur,int i,int j){
        StringBuilder str = new StringBuilder(cur);
        str.setCharAt(i,cur.charAt(j));
        str.setCharAt(j,cur.charAt(i));
        return str.toString();

    }
}