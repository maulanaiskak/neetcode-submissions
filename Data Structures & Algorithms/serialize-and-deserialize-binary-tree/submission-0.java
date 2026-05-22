/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        var builder = new StringBuilder();
        var queue = new LinkedList<TreeNode>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            var node = queue.poll();

            if (node == null) {
                builder.append("N,");
            } else {
                builder.append(node.val).append(",");
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }

        return builder.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        var tokens = data.split(",");
        if (tokens[0].equals("N")) {
            return null;
        }

        var root = new TreeNode(Integer.parseInt(tokens[0]));
        var queue = new ArrayDeque<TreeNode>();  // ← queue of TreeNode, bukan String
        queue.offer(root);
        var i = 1;

        while (!queue.isEmpty()) {
            var node = queue.poll();

            // assign left
            if (!tokens[i].equals("N")) {
                node.left = new TreeNode(Integer.parseInt(tokens[i]));
                queue.offer(node.left);
            }
            i++;

            // assign right
            if (!tokens[i].equals("N")) {
                node.right = new TreeNode(Integer.parseInt(tokens[i]));
                queue.offer(node.right);
            }
            i++;
        }

        return root;
    }
}
