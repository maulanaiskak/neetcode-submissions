class Solution {
    public int uniquePaths(int m, int n) {
        // At each cell, we can only come from the left or from above.
        // So paths to (row, col) = paths to (row, col-1) + paths to (row-1, col).
        //
        // We can reuse previously computed results (cells to the left and above
        // are always computed first), so we cache them in a 2D grid.
        //
        // base: first row and first col = 1 (only one way to reach them, go straight)
        //
        // e.g. 3x3 grid:
        //   1 1 1
        //   1 2 3
        //   1 3 6

        var dp = new int[m][n];

        for (var row = 0; row < m; row++) {
            for (var col = 0; col < n; col++) {
                if (row == 0 || col == 0) {
                    dp[row][col] = 1;
                } else {
                    dp[row][col] = dp[row][col - 1] + dp[row - 1][col];
                }
            }
        }

        return dp[m - 1][n - 1];
    }
}