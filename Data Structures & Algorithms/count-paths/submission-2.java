class Solution {
    public int uniquePaths(int m, int n) {
        // We start at the top-left cell (0, 0) and want to reach
        // the bottom-right cell (m - 1, n - 1).
        //
        // We can only move in two directions:
        // 1. Right  -> (row, col + 1)
        // 2. Down   -> (row + 1, col)
        //
        // Instead of exploring every possible path, we use Dynamic
        // Programming (DP) to avoid recalculating the same subproblems.
        //
        // STATE:
        // dp[row][col] represents the number of unique paths needed
        // to reach cell (row, col) from the starting cell (0, 0).
        //
        // TRANSITION:
        // To reach any cell (row, col), we must come from either:
        // 1. The cell directly above: (row - 1, col)
        // 2. The cell directly to the left: (row, col - 1)
        //
        // Therefore:
        // dp[row][col] = dp[row - 1][col] + dp[row][col - 1]
        //
        // BASE CASE:
        // The first row and first column contain only one possible path.
        // - First row: We can only move right.
        // - First column: We can only move down.
        //
        // Therefore:
        // dp[0][col] = 1
        // dp[row][0] = 1
        //
        // TRAVERSAL ORDER:
        // Iterate from top-left to bottom-right.
        // This ensures that the values from above and the left
        // have already been calculated before computing the current cell.

        var dp = new int[m][n];
        for (var row = 0; row < m; row++) {
            for (var col = 0; col < n; col++) {
                // Base case: first row or first column.
                // There is only one way to reach these cells.
                if (row == 0 || col == 0) {
                    dp[row][col] = 1;
                } else {
                    // Calculate the number of paths by adding:
                    // - Paths from the cell above.
                    // - Paths from the cell to the left.
                    dp[row][col] = dp[row - 1][col] + dp[row][col - 1];
                }
            }
        }
        // The bottom-right cell contains the total number
        // of unique paths from the starting point to the destination.
        return dp[m - 1][n - 1];
    }
}

// TIME COMPLEXITY: O(m * n)
// We visit every cell in the grid exactly once.
//
// SPACE COMPLEXITY: O(m * n)
// We use a 2D DP array to store the number of paths for each cell.