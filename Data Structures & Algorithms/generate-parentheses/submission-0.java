class Solution {
    private List<String> result = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        backtrack(n, new StringBuilder(), 0, 0);
        return result;
    }

    private void backtrack(int n, StringBuilder current, int open, int close) {
        if (current.length() == n * 2) {
            result.add(current.toString());
            return;
        }

        if (open < n) {
            current.append("(");
            backtrack(n, current, open + 1, close);
            current.deleteCharAt(current.length() - 1);
        }

        if (close < open) {
            current.append(")");
            backtrack(n, current, open, close + 1);
            current.deleteCharAt(current.length() - 1);
        }
    }
}
