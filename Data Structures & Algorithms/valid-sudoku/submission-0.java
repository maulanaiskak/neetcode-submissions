class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character>[] rows = new HashSet[9];
        Set<Character>[] cols = new HashSet[9];
        Set<Character>[] squares = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            squares[i] = new HashSet<>();
        }

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {

                char val = board[r][c];
                if (val == '.') {
                    continue;
                }

                int square = (r / 3) * 3 + (c / 3);

                if (rows[r].contains(val) ||
                    cols[c].contains(val) ||
                    squares[square].contains(val)) {
                    return false;
                }

                rows[r].add(val);
                cols[c].add(val);
                squares[square].add(val);
            }
        }

        return true;
    }
}