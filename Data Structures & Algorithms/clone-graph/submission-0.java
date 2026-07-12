/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    private Map<Node, Node> nodeMap = new HashMap<>();

    public Node cloneGraph(Node node) {
        dfs(node);
        return nodeMap.get(node);
    }

    private Node dfs(Node node) {
        if (node == null) {
            return null;
        }

        if (nodeMap.containsKey(node)) {
            return nodeMap.get(node);
        }

        var clone = new Node(node.val);
        nodeMap.put(node, clone);

        var neighbors = new ArrayList<Node>();

        for (var neighbor : node.neighbors) {
            neighbors.add(dfs(neighbor));
        }

        clone.neighbors = neighbors;

        return clone;
    }
}