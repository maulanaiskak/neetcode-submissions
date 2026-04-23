class Solution {
    public void solve(char[][] board) {
        // Instead of finding surrounded regions directly (hard — need to prove fully enclosed),
        // we reverse the problem: find all 'O's that are NOT surrounded (safe),
        // then everything else is captured.
        //
        // Safe 'O's = those connected (4-directionally) to any border 'O'.
        // We DFS from every border cell to mark them as 'S' (safe).
        for (var row = 0; row < board.length; row++) {
            for (var col = 0; col < board[0].length; col++) {
                if (row == 0 || col == 0 || row == board.length - 1 || col == board[0].length - 1) {
                    dfs(board, row, col);
                }
            }
        }

        // Cleanup pass:
        // - 'O' never reached by border DFS = truly surrounded = capture to 'X'
        // - 'S' = was safe, restore to 'O'
        // - 'X' = unchanged
        for (var row = 0; row < board.length; row++) {
            for (var col = 0; col < board[0].length; col++) {
                if (board[row][col] == 'O') {
                    board[row][col] = 'X';
                }

                if (board[row][col] == 'S') {
                    board[row][col] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int row, int col) {
        // Base case: out of bounds, already visited ('S'), or not an 'O' — nothing to do
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != 'O') {
            return;
        }

        // Mark as safe — connected to border, cannot be captured
        board[row][col] = 'S';

        // Explore all 4 directions to flood-fill the entire safe region
        dfs(board, row + 1, col);
        dfs(board, row - 1, col);
        dfs(board, row, col + 1);
        dfs(board, row, col - 1);
    }
}