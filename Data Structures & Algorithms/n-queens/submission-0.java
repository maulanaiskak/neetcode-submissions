class Solution {
    private Set<Integer> cols = new HashSet<>();
    private Set<Integer> diag1 = new HashSet<>();
    private Set<Integer> diag2 = new HashSet<>();
    private List<List<String>> result = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        backtrack(n, 0, new ArrayList<>());
        return result;
    }

    private void backtrack(int n, int row, List<String> current) {
        if (row == n) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (var col = 0; col < n; col++) {
            if (cols.contains(col) || diag1.contains(row - col) || diag2.contains(row + col)) {
                continue;
            }

            var queen = new StringBuilder();
            queen.append(".".repeat(n));
            queen.setCharAt(col, 'Q');
            current.add(queen.toString());
            cols.add(col);
            diag1.add(row - col);
            diag2.add(row + col);

            backtrack(n, row + 1, current);
            current.removeLast();
            cols.remove(col);
            diag1.remove(row - col);
            diag2.remove(row + col);
        }
    }
}
