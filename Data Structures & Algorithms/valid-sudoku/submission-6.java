class Solution {
    public boolean isValidSudoku(char[][] board) {
        var rows = new HashSet[9];
        var cols = new HashSet[9];
        var squares = new HashSet[9];

        for (var i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            squares[i] = new HashSet<>();
        }

        for (var row = 0; row < 9; row++) {
            for (var col = 0; col < 9; col++) {
                if (board[row][col] == '.') {
                    continue;
                }

                var square = (row / 3) * 3 + (col / 3);

                if (!rows[row].add(board[row][col])
                    || !cols[col].add(board[row][col])
                    || !squares[square].add(board[row][col])) {
                    return false;
                }
            }
        }

        return true;
    }
}
