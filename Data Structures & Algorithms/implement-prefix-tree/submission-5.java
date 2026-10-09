class PrefixTree {
    private TrieNode root;

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd;
    }

    public PrefixTree() {
         root = new TrieNode();
    }

    public void insert(String word) {
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
        var current = root;

        for (var c : word.toCharArray()) {
            var idx = c - 'a';

            if (current.children[idx] == null) {
                return false;
            }

            current = current.children[idx];
        }

        return current.isEnd;
    }

    public boolean startsWith(String prefix) {
        var current = root;

        for (var c : prefix.toCharArray()) {
            var idx = c - 'a';

            if (current.children[idx] == null) {
                return false;
            }

            current = current.children[idx];
        }

        return true;
    }
}
