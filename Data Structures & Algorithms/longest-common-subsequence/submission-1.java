class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        // We want to find the longest subsequence shared by both strings
        // while preserving the relative order of characters.
        //
        // INTUITION:
        // Instead of generating all possible subsequences, we can solve
        // smaller prefix problems and reuse their results.
        //
        // At each step, compare the last characters of both prefixes:
        //
        // 1. If they match:
        //    Include the matching character and extend the LCS
        //    of both prefixes without their last characters.
        //    dp[row][col] = dp[row - 1][col - 1] + 1
        //
        // 2. If they don't match:
        //    Skip the last character of either text1 or text2.
        //    Take whichever choice produces the longer subsequence.
        //    dp[row][col] = max(dp[row - 1][col], dp[row][col - 1])
        //
        // WHY DP?
        // Different choices can lead to the same smaller prefix problems.
        // Store their results to avoid recalculating them.
        //
        // STATE:
        // dp[row][col] represents the LCS length between the first
        // row characters of text1 and the first col characters of text2.
        //
        // BASE CASE:
        // An empty string has an LCS of 0 with any string.
        // Therefore, the first row and column are initialized to 0.
        //
        // We add an extra row and column to represent empty prefixes
        // and avoid out-of-bounds checks.
        //
        // EXAMPLE:
        // text1 = "cat", text2 = "crabt"
        //
        //       ""  c  r  a  b  t
        //   ""   0  0  0  0  0  0
        //    c   0  1  1  1  1  1
        //    a   0  1  1  2  2  2
        //    t   0  1  1  2  2  3
        //
        // TRAVERSAL:
        // Iterate from top-left to bottom-right so that the required
        // subproblems (top, left, and diagonal) are already computed.

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
                    dp[row][col] = Math.max(
                        dp[row - 1][col],
                        dp[row][col - 1]
                    );
                }
            }
        }

        return dp[rows][cols];
    }
}

// TIME COMPLEXITY: O(m * n)
// SPACE COMPLEXITY: O(m * n)