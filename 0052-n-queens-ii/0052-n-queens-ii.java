class Solution {
    int cnt = 0;
    public int totalNQueens(int n) {
        boolean[] rowf = new boolean[n];
        boolean[] colf = new boolean[n];
        boolean[] trblf = new boolean[2*n-1];
        boolean[] tlbrf = new boolean[2*n-1];
        boolean[][] board = new boolean[n][n];
        solve(rowf,colf,trblf,tlbrf,board,n,0);
        return cnt;
    }

    void solve(boolean[] rowf,boolean[] colf,boolean[] trblf,boolean[] tlbrf,boolean[][] board,int n ,int row){
        if(row == n){
            cnt++;
            return;
        }
        for(int col = 0;col < n;col++){
            if(isvalid(rowf,colf,trblf,tlbrf,board,n,row,col)){
            rowf[row] = true;
            colf[col] = true;
            trblf[row+col] = true;
            tlbrf[n-1-(row - col)] = true;
            board[row][col] = true;
            solve(rowf,colf,trblf,tlbrf,board,n,row+1);
            rowf[row] = false;
            colf[col] = false;
            trblf[row+col] = false;
            tlbrf[n-1-(row - col)] = false;
            board[row][col] = false;
            }
        }
    }
    boolean isvalid(boolean[] rowf,boolean[] colf,boolean[] trblf,boolean[] tlbrf,boolean[][] board,int n ,int row,int col){
        return !rowf[row] && !colf[col] && !trblf[row+col] 
        && !tlbrf[n -1-(row-col)] && !board[row][col];
    }
} 