class WordDictionary {
    private TrieNode root;

    private class TrieNode {
        private TrieNode[] children = new TrieNode[26];
        private boolean isEndOfWord = false;
    }

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        var current = root;

        for (var c : word.toCharArray()) {
            if (current.children[c - 'a'] == null) {
                current.children[c - 'a'] = new TrieNode();
            }

            current = current.children[c - 'a'];
        }

        current.isEndOfWord = true;
    }

    public boolean search(String word) {
        return exist(word, 0, root);
    }

    private boolean exist(String word, int index, TrieNode node) {
        if (node == null) {
            return false;
        }

        if (index == word.length()) {
            return node.isEndOfWord;
        }

        if (word.charAt(index) == '.') {
            for (var i = 0; i < node.children.length; i++) {
                if (exist(word, index + 1, node.children[i])) {
                    return true;
                }
            }
            
            return false;
        } else {
            if (node.children[word.charAt(index) - 'a'] == null) {
                return false;
            }

            return exist(word, index + 1, node.children[word.charAt(index) - 'a']);
        }
    }
}
