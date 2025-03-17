class Solution {
    int row, col;
    public boolean exist(char[][] board, String word) {
        
         row = board.length;
         col = board[0].length;
        for(int r = 0;r<row;r++){
            for(int c = 0;c<col;c++){
                if(board[r][c] == word.charAt(0)){
                    char temp = board[r][c];
                    board[r][c] = '-';
                    if(solve(board,word,1,r,c)){
                        return true;
                    }
                    board[r][c] = temp;
                }
            }
        }
        return false;
    }

    boolean solve(char[][] board,String word,int i,int r,int c){
        if(i == word.length()){
            return true;
        }

        int[][] adj = new int[][]{
            {-1,0},
            {1,0},
            {0,-1},
            {0,1}
        };

        for(int k = 0;k<4;k++){
            int curR = r + adj[k][0];
            int curC = c + adj[k][1];
            if(curR >= 0 && curR < row && curC >= 0 && curC < col){
                if(board[curR][curC] == word.charAt(i)){
                    char temp = board[r][c];
                    board[r][c] = '-';
                    if(solve(board,word,i+1,curR,curC)){
                        return true;
                    }
                    board[r][c] = temp;
                }
            }
        }
        return false;
    }
}