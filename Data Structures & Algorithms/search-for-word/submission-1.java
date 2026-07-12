class Solution {
    public boolean exist(char[][] board, String word) {
        for (var i = 0; i < board.length; i++) {
            for (var j = 0; j < board[0].length; j++) {
                if (dfs(i, j, board, word, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(int i, int j, char[][] board, String word, int index) {
        if (index >= word.length()) {
            return true;
        }

        if ( i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == '#') {
            return false;
        }

        if (board[i][j] != word.charAt(index)) {
            return false;
        }

        var current = board[i][j];
        board[i][j] = '#';

        var result =  dfs(i + 1, j, board, word, index + 1)
                    || dfs(i - 1, j, board, word, index + 1)
                    || dfs(i, j + 1, board, word, index + 1)
                    || dfs(i, j - 1, board, word, index + 1);

        board[i][j] = current;
        return result;
    }
}
