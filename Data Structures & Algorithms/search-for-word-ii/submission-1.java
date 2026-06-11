class Solution {
    private class Node {
        private Node[] child = new Node[26];
        private boolean isEndOfWord;
    }

    private Node root = new Node();

    private void addWord(String word) {
        var current = root;

        for (var c : word.toCharArray()) {
            if (current.child[c - 'a'] == null) {
                current.child[c - 'a'] = new Node();
            }

            current = current.child[c - 'a'];
        }

        current.isEndOfWord = true;
    }

    public List<String> findWords(char[][] board, String[] words) {
        for (var word : words) {
            addWord(word);
        }

        var result = new ArrayList<String>();
        for (var row = 0; row < board.length; row++) {
            for (var col = 0; col < board[0].length; col++) {
                dfs(root, row, col, board, new StringBuilder(), result);
            }
        }

        return result;
    }

    private void dfs(Node node, int row, int col, char[][] board, StringBuilder builder, List<String> result) {
        if (row < 0 || row > board.length - 1 
            || col < 0 || col > board[0].length - 1 
            || node == null || node.child == null) {
            return;
        }

        var c = board[row][col];

        if (c == '#' || node.child[c - 'a'] == null) {
            return;
        }

        builder.append(c);
        board[row][col] = '#';

        if (node.child[c - 'a'].isEndOfWord) {
            result.add(builder.toString());
            node.child[c - 'a'].isEndOfWord = false;
        }

        dfs(node.child[c - 'a'], row + 1, col, board, builder, result);
        dfs(node.child[c - 'a'], row - 1, col, board, builder, result);
        dfs(node.child[c - 'a'], row, col + 1, board, builder, result);
        dfs(node.child[c - 'a'], row, col - 1, board, builder, result);

        board[row][col] = c;

        builder.deleteCharAt(builder.length() - 1);
    }
}
