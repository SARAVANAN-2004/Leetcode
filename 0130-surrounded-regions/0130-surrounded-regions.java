class Solution {
    int row,col;
    public void solve(char[][] board) {
        row = board.length ;
        col = board[0].length;

        for(int r = 0;r<row;r++){
            if(board[r][0] == 'O'){
                dfs(board,r,0);
            }
            if(board[r][col-1] == 'O'){
                dfs(board,r,col-1);
            }
        }
        for(int c = 0;c<col;c++){
            if(board[0][c] == 'O'){
                dfs(board,0,c);
            }
            if(board[row-1][c] == 'O'){
                dfs(board,row-1,c);
            }
        }
        // for(char[] arr:board){
        //     System.out.println(Arrays.toString(arr));
        // }

        for(int r = 0;r<row;r++){
            for(int c = 0;c<col;c++){
                if(board[r][c] == '-'){
                    board[r][c] = 'O';
                }else if(board[r][c] == 'O'){
                    board[r][c] = 'X';
                }
            }
        }
    }

    void dfs(char[][] board,int r,int c){
        if(r < 0 || r >= row || c < 0 || c >= col || board[r][c] != 'O'){
            return;
        }
        board[r][c] = '-';

        dfs(board,r-1,c);
        dfs(board,r+1,c);
        dfs(board,r,c-1);
        dfs(board,r,c+1);
    }

}