class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        var memo = new Boolean[s1.length() + 1][s2.length() + 1];
        return dfs(s1, s2, s3, 0, 0, memo);
    }

    private boolean dfs(String s1, String s2, String s3, int i, int j, Boolean[][] memo) {
        if (memo[i][j] != null) {
            return memo[i][j];
        }

        if (i == s1.length() && j == s2.length()) {
            return i + j == s3.length();
        }

        if (i + j >= s3.length()) {
            return false;
        }

        var result = false;
        if (i < s1.length() && s3.charAt(i + j) == s1.charAt(i)) {
            result = result || dfs(s1, s2, s3, i + 1, j, memo);
        } 
        
        if (j < s2.length() && s3.charAt(i + j) == s2.charAt(j))  {
            result = result || dfs(s1, s2, s3, i, j + 1, memo);
        }

        memo[i][j] = result;
        return result;
    }
}
