class Solution {
    public List<List<String>> solveNQueens(int n) {
        boolean[] rowf = new boolean[n];
        boolean[] colf = new boolean[n];
        boolean[] trblf = new boolean[2*n-1];
        boolean[] tlbrf = new boolean[2*n-1];
        boolean[][] board = new boolean[n][n];

        List<List<String>> ans = new ArrayList<>();
        solve(rowf,colf,trblf,tlbrf,board,ans,n,0);
        return ans;
    }
    public void solve(boolean[] rowf, boolean[] colf, boolean[] trblf, 
    boolean[] tlbrf, boolean[][] board, List<List<String>> ans, int n,int row){
        if(row == n){
            List<String> temp = new ArrayList<>();
            for(int r = 0;r<n;r++){
                StringBuilder sb = new StringBuilder();
                for(int c = 0;c<n;c++){
                    if(board[r][c]){
                        sb.append("Q");
                    }else{
                        sb.append(".");
                    }
                }
                temp.add(sb.toString());
            }
            ans.add(temp);
            return;
        }

        for(int col = 0; col < n;col++){
            if(isvalid(rowf,colf,trblf,tlbrf,board,n,row,col)){
            rowf[row] = true;
            colf[col] = true;
            trblf[row+col] =true;
            tlbrf[n-1-(row-col)] = true;
            board[row][col] = true;
            solve(rowf,colf,trblf,tlbrf,board,ans,n,row+1);
            rowf[row] = false;
            colf[col] = false;
            trblf[row+col] =false;
            tlbrf[n-1-(row-col)] = false;
            board[row][col] = false;
            }
        }

    }

    boolean isvalid(boolean[] rowf, boolean[] colf, boolean[] trblf, 
    boolean[] tlbrf, boolean[][] board,int n,int row,int col){
        if(rowf[row] || colf[col] || trblf[row+col] || tlbrf[n - 1-(row-col)] ||
        board[row][col]){
            return false;
        } 
        return true;
    }
}