class Solution {
    private List<String> result = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        backtrack(0, 0, n, new StringBuilder());
        return result;
    }

    private void backtrack(int open, int close, int n, StringBuilder builder) {
        if (builder.length() == n * 2) {
            result.add(builder.toString());
            return;
        }

        if (open < n) {
            builder.append("(");
            backtrack(open + 1, close, n, builder);
            builder.deleteCharAt(builder.length() - 1);
        }

        if (close < open) {
            builder.append(")");
            backtrack(open, close + 1, n, builder);
            builder.deleteCharAt(builder.length() - 1);
        }
    }
}
