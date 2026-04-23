class Solution {
    public int minDistance(String word1, String word2) {
        // We need to track minimum operations for each (i, j) subproblem
        // i = how far we've processed word1, j = how far we've processed word2
        // Without memo, same (i,j) gets recomputed exponentially many times
        // +1 because i and j can reach word1.length() and word2.length() as valid states
        var memo = new Integer[word1.length() + 1][word2.length() + 1];
        return dfs(word1, word2, 0, 0, memo);
    }

    private int dfs(String word1, String word2, int i, int j, Integer[][] memo) {
        // Return cached result if this (i,j) state was already computed
        if (memo[i][j] != null) {
            return memo[i][j];
        }

        // Base case: word1 is exhausted, only option is to insert remaining word2 chars
        if (i == word1.length()) {
            memo[i][j] = word2.length() - j;
            return memo[i][j];
        }

        // Base case: word2 is exhausted, only option is to delete remaining word1 chars
        if (j == word2.length()) {
            memo[i][j] = word1.length() - i;
            return memo[i][j];
        }

        if (word1.charAt(i) == word2.charAt(j)) {
            // Characters match — no operation needed, advance both pointers
            memo[i][j] = dfs(word1, word2, i + 1, j + 1, memo);
        } else {
            // Characters don't match — try all 3 operations, pick the cheapest:
            // replace: fix mismatch at (i,j), advance both pointers       -> dfs(i+1, j+1)
            // delete:  remove word1[i], advance only i                    -> dfs(i+1, j)
            // insert:  insert word2[j] into word1, advance only j         -> dfs(i, j+1)
            var replace = dfs(word1, word2, i + 1, j + 1, memo);
            var delete  = dfs(word1, word2, i + 1, j,     memo);
            var insert  = dfs(word1, word2, i,     j + 1, memo);

            memo[i][j] = 1 + Math.min(replace, Math.min(delete, insert));
        }

        return memo[i][j];
    }
}