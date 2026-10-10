class Solution {
    public void solve(char[][] board) {
        for (var row = 0; row < board.length; row ++) {
            dfs(board, row, 0);
            dfs(board, row, board[0].length - 1);
        }

        for (var col = 0; col < board[0].length; col ++) {
            dfs(board, 0, col);
            dfs(board, board.length - 1, col);
        }

        for (var row = 0; row < board.length; row ++) {
            for (var col = 0; col < board[0].length; col ++) {
                if (board[row][col] == 'O') {
                    board[row][col] = 'X';
                }
            }
        }

         for (var row = 0; row < board.length; row ++) {
            for (var col = 0; col < board[0].length; col ++) {
                if (board[row][col] == 'T') {
                    board[row][col] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int row, int col) {
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || board[row][col] != 'O') {
            return;
        }

        board[row][col] = 'T';

        dfs(board, row + 1, col);
        dfs(board, row - 1, col);
        dfs(board, row, col + 1);
        dfs(board, row, col - 1);
    }
}
