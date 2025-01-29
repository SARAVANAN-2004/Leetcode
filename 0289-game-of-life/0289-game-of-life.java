class Solution {
    public void gameOfLife(int[][] board) {
        int r = board.length, c = board[0].length;
        for(int i = 0;i<r;i++){
            for(int j = 0;j<c;j++){
                int liveCell = cnt(i,j,board,r,c);
                if(board[i][j] == 0){
                    if(liveCell == 3){
                    board[i][j] = 2;
                    }
                }else{
                    if(liveCell == 2 || liveCell == 3){
                        board[i][j] = 3;
                    }
                }
            }
        }
        for(int i = 0;i<r;i++){
            for(int j = 0;j<c;j++){
                if(board[i][j] == 2 || board[i][j] == 3){
                    board[i][j] = 1;
                }else{
                    board[i][j] = 0;
                }
            }
        }


    }

    int cnt(int r,int c,int[][] board,int row,int col){
        int[] adjR = new int[]{-1,-1,-1,0,0,1,1,1};
        int[] adjC = new int[]{-1,0,1,-1,1,-1,0,1};
        int lives = 0;
        for(int i = 0;i<8;i++){
            int curR = adjR[i]+r;
            int curC = adjC[i] + c;
            if(curR >=0 && curR < row && curC >= 0 && curC < col){
                if(board[curR][curC] ==  1 || board[curR][curC] == 3){
                lives += 1;
                }
            }
        }
        return lives;
    }
}