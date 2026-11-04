class Solution {
    public int uniquePaths(int m, int n) {
        // STATE:
        // dp[col] represents the number of unique paths to reach
        // the current cell in the current row.
        //
        // BASE CASE:
        // Initially, every cell in the first row has exactly one path.
        // We can only move right to reach those cells.
        var dp = new int[n];
        Arrays.fill(dp, 1);

        // TRANSITION:
        // dp[col] = dp[col] + dp[col - 1]
        //
        // dp[col]     -> paths from above (previous row).
        // dp[col - 1] -> paths from the left (current row).
        //
        // We update the array from left to right so that:
        // - dp[col] still contains the value from the previous row.
        // - dp[col - 1] already contains the updated value from this row.
        for (var row = 1; row < m; row++) {
            for (var col = 1; col < n; col++) {
                dp[col] += dp[col - 1];
            }
        }
        // The last element contains the total number of unique paths.
        return dp[n - 1];
    }

}