class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        // At each (row, col), we compare text1[row-1] and text2[col-1]:
        //   - if match: dp[row][col] = dp[row-1][col-1] + 1 (extend previous LCS)
        //   - if no match: dp[row][col] = max(dp[row-1][col], dp[row][col-1]) (best without one char)
        //
        // We add 1 padding row and col (index 0) to avoid bounds check on i-1, j-1.
        // base: dp[0][...] = dp[...][0] = 0 (empty string has LCS 0)
        //
        // e.g. text1="cat", text2="crabt":
        //     ""  c  r  a  b  t
        //  ""  0  0  0  0  0  0
        //  c   0  1  1  1  1  1
        //  a   0  1  1  2  2  2
        //  t   0  1  1  2  2  3

        var rows = text1.length();
        var cols = text2.length();
        var dp = new int[rows + 1][cols + 1];

        for (var row = 1; row <= rows; row++) {
            for (var col = 1; col <= cols; col++) {
                var char1 = text1.charAt(row - 1);
                var char2 = text2.charAt(col - 1);

                if (char1 == char2) {
                    dp[row][col] = dp[row - 1][col - 1] + 1;
                } else {
                    dp[row][col] = Math.max(dp[row - 1][col], dp[row][col - 1]);
                }
            }
        }

        return dp[rows][cols];
    }
}