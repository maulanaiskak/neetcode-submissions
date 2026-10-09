class WordDictionary {
    private TrieNode root;

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd;
    }

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        var current = root;

        for (var c : word.toCharArray()) {
            var idx = c - 'a';

            if (current.children[idx] == null) {
                current.children[idx] = new TrieNode();
            }

            current = current.children[idx];
        }

        current.isEnd = true;
    }

    public boolean search(String word) {
        return dfs(root, word, 0);
    }
    
    private boolean dfs(TrieNode node, String word, int idx) {
        if (idx == word.length()) {
            return node.isEnd;
        }

        var c = word.charAt(idx);

        if (c == '.') {
            for (var child : node.children) {
                if (child != null && dfs(child, word, idx + 1)) return true;
            }
            return false;
        }

        var child = node.children[c - 'a'];
        if (child == null) {
            return false;
        }

        return dfs(child, word, idx + 1);
    }
}
