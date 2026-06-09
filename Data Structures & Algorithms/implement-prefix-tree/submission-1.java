class PrefixTree {
    private class Node {
        private Node[] children = new Node[26];
        private boolean isEndOfWord;
    }

    private Node root;

    public PrefixTree() {
        root = new Node();
    }

    public void insert(String word) {
        var current = root;
        for (var c : word.toCharArray()) {
            if (current.children[c - 'a'] == null) {
                current.children[c - 'a'] = new Node();
            }

            current = current.children[c - 'a'];
        }

        current.isEndOfWord = true;
    }

    public boolean search(String word) {
        var current = root;

        for (var c : word.toCharArray()) {
            if (current.children[c - 'a'] == null) {
                return false;
            }

            current = current.children[c - 'a'];
        }

        return current.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        var current = root; 

        for (var c : prefix.toCharArray()) {
            if (current.children[c - 'a'] == null) {
                return false;
            }

            current = current.children[c - 'a'];
        }

        return true;
    }
}
