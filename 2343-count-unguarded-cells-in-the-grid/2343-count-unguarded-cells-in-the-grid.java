class Solution {

    private static final int UNGUARDED = 0;
    private static final int GUARDED = 1;
    private static final int GUARD = 2;
    private static final int WALL = 3;

    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {

        int[][] grid = new int[m][n];

        for (int[] guard : guards) {
            grid[guard[0]][guard[1]] = GUARD;
        }

        for (int[] wall : walls) {
            grid[wall[0]][wall[1]] = WALL;
        }

        for (int row = 0; row < m; row++) {

            boolean isGuardLineActive = grid[row][0] == GUARD;
            for (int col = 1; col < n; col++) {
                isGuardLineActive = updateCellVisibility(
                    grid,
                    row,
                    col,
                    isGuardLineActive
                );
            }

            isGuardLineActive = grid[row][n - 1] == GUARD;
            for (int col = n - 2; col >= 0; col--) {
                isGuardLineActive = updateCellVisibility(
                    grid,
                    row,
                    col,
                    isGuardLineActive
                );
            }
        }


        for (int col = 0; col < n; col++) {

            boolean isGuardLineActive = grid[0][col] == GUARD;
            for (int row = 1; row < m; row++) {
                isGuardLineActive = updateCellVisibility(
                    grid,
                    row,
                    col,
                    isGuardLineActive
                );
            }

            isGuardLineActive = grid[m - 1][col] == GUARD;
            for (int row = m - 2; row >= 0; row--) {
                isGuardLineActive = updateCellVisibility(
                    grid,
                    row,
                    col,
                    isGuardLineActive
                );
            }
        }


        int count = 0;
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == UNGUARDED) {
                    count++;
                }
            }
        }

        return count;
    }

    private boolean updateCellVisibility(
        int[][] grid,
        int row,
        int col,
        boolean isGuardLineActive
    ) {
        if (grid[row][col] == GUARD) {
            return true;
        }

        if (grid[row][col] == WALL) {
            return false;
        }

        if (isGuardLineActive) {
            grid[row][col] = GUARDED;
        }

        return isGuardLineActive;
    }
}