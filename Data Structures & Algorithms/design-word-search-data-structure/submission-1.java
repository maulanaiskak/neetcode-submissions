class WordDictionary {
    private class Node {
        private Node[] child = new Node[26];
        private boolean isEndOfWord;
    }

    private Node root;

    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        var current = root;

        for (var c : word.toCharArray()) {
            if (current.child[c - 'a'] == null) {
                current.child[c - 'a'] = new Node();
            }

            current = current.child[c - 'a'];
        }

        current.isEndOfWord = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int index, Node node) {
        if (node == null) {
            return false;
        }

        if (index == word.length()) {
            return node.isEndOfWord;
        }

        var c = word.charAt(index);

        if (c != '.') {
            if (node.child[c - 'a'] == null) {
                return false;
            }

            return dfs(word, index + 1, node.child[c - 'a']);
        }

        for (Node child : node.child) {
            if (child != null && dfs(word, index + 1, child)) {
                return true;
            }
        }
        
        return false;
    }
}
