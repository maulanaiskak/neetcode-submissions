class Solution {
    public int uniquePaths(int m, int n) {
        //   0 0 0 0  0  0
        // 0 1 1 1 1  1  1
        // 0 1 2 3 4  5  6
        // 0 1 3 6 10 15 21

        var dp = new int[m][n];

        for (var i = 0; i < m; i++) {
            for (var j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                }
            }
        }

        return dp[m-1][n-1];

    }
}
