class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rflag = new boolean[10][10];
        boolean[][] cflag = new boolean[10][10];
        boolean[][] subMat = new boolean[10][10];
        for(int r = 0;r<9;r++){
            for(int c = 0;c<9;c++){
                if(board[r][c] == '.') continue;
                int val = (int)(board[r][c] - '0');
                if(rflag[r][val] || cflag[c][val] || subMat[(r/3)*3+(c/3)][val]){
                    // System.out.println(val+" "+r+" "+c);
                    // System.out.println(subMat[(r/3)*3+(c/3)][val]);
                    // System.out.println(rflag[val] +" "+ cflag[val]);

                    return false;
                }

                rflag[r][val] = true;
                cflag[c][val] = true;
                subMat[(r/3)*3+(c/3)][val] = true;
            }
        }
        return true;
    }
}