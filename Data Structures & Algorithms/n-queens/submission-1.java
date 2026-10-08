class Solution {
    private List<List<String>> result = new ArrayList<>();
    private Set<Integer> cols = new HashSet<>();
    private Set<Integer> diag1 = new HashSet<>();
    private Set<Integer> diag2 = new HashSet<>();

    public List<List<String>> solveNQueens(int n) {
        var board = new char[n][n];
        for (var i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        backtrack(board, 0, new ArrayList<>());
        return result;
    }

    private void backtrack(char[][] board, int row, List<String> current) {
        if (row == board.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (var col = 0; col < board[0].length; col++) {
            if (cols.contains(col) || diag1.contains(row - col) || diag2.contains(row + col)) {
                continue;
            }

            board[row][col] = 'Q';
            current.add(new String(board[row]));

            cols.add(col); 
            diag1.add(row - col); 
            diag2.add(row + col);  

            backtrack(board, row + 1, current);
            
            cols.remove(col); 
            diag1.remove(row - col); 
            diag2.remove(row + col); 

            current.removeLast();
            board[row][col] = '.';
        }
    }
}
