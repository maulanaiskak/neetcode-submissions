class Solution {
    private List<String> result = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        backtrack(new StringBuilder(), 0, 0, n);
        return result;
    }

    private void backtrack(StringBuilder sb, int open, int close, int n) {
        if (sb.length() == 2*n) {
            result.add(sb.toString());
            return;
        }

        if (open < n) {
            sb.append('(');
            backtrack(sb, open + 1, close, n);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (close < open) {
            sb.append(')');
            backtrack(sb, open, close + 1, n);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
