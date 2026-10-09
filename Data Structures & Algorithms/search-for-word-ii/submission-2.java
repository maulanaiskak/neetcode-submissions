class Solution {
    private TrieNode root = new TrieNode();
    private List<String> result = new ArrayList<>();

    class TrieNode {
        TrieNode[] child = new TrieNode[26];
        String word;
    }

    public List<String> findWords(char[][] board, String[] words) {
        addWords(words);

        for (var row = 0; row < board.length; row++) {
            for (var col = 0; col < board[0].length; col++) {
                dfs(board, row, col, root);
            }
        }

        return result;
    }

    private void addWords(String[] words) {
        for (var word : words) {
            var current = root;

            for (var c : word.toCharArray()) {
                var idx = c - 'a';

                if (current.child[idx] == null) {
                    current.child[idx] = new TrieNode();
                }

                current = current.child[idx];
            }

            current.word = word;
        }
    }

    void dfs(char[][] board, int row, int col, TrieNode node) {
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length) {
            return;
        }

        var c = board[row][col];
        if (c == '#' || node.child[c - 'a'] == null) {
            return;
        }

        node = node.child[c - 'a'];
        if (node.word != null) {
            result.add(node.word);
            node.word = null;
        }

        board[row][col] = '#';

        dfs(board, row + 1, col, node);
        dfs(board, row - 1, col, node);
        dfs(board, row, col + 1, node);
        dfs(board, row, col - 1, node);

        board[row][col] = c;
    }
}
