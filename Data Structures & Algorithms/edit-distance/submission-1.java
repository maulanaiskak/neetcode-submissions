class Solution {
    public int minDistance(String word1, String word2) {
        var memo = new Integer[word1.length() + 1][word2.length() + 1];
        return dfs(word1, word2, 0, 0, memo);
    }

    private int dfs(String word1, String word2, int i, int j, Integer[][] memo) {
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        
        if (i == word1.length()) {
            memo[i][j] = word2.length() - j;
            return memo[i][j];
        }

        if (j == word2.length()) {
            memo[i][j] = word1.length() - i;
            return memo[i][j];
        }

        if (word1.charAt(i) == word2.charAt(j)) {
            memo[i][j] = dfs(word1, word2, i + 1, j + 1, memo);
            return memo[i][j];
        } else {
            memo[i][j] = 1 + Math.min(dfs(word1, word2, i+1, j+1, memo), 
                    Math.min(dfs(word1, word2, i+1, j, memo), dfs(word1, word2, i, j+1, memo)));
            return memo[i][j];
        }
    }
}
