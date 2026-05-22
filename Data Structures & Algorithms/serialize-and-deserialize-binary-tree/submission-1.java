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
        var queue = new LinkedList<TreeNode>();
        queue.offer(root);

        var result = new StringBuilder();

        while (!queue.isEmpty()) {
            var size = queue.size();

            for (var i = 0; i < size; i++) {
                var node = queue.poll();

                if (node != null) {
                    result.append(node.val).append(",");
                    queue.offer(node.left);
                    queue.offer(node.right);
                } else {
                    result.append("N,");
                }
            }
        }

        return result.toString();
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        var list = data.split(",");

        if (list.length == 0 || list[0].equals("N")) {
            return null;
        }

        var root = new TreeNode(Integer.parseInt(list[0]));
        var queue = new LinkedList<TreeNode>();
        queue.offer(root);
        var i = 1;

        while(!queue.isEmpty()) {
            var node = queue.poll();

            if (!list[i].equals("N")) {
                node.left = new TreeNode(Integer.parseInt(list[i]));
                queue.offer(node.left);
            }
            i++;

            if (!list[i].equals("N")) {
                node.right = new TreeNode(Integer.parseInt(list[i]));
                queue.offer(node.right);
            }
            i++;

        }

        return root;

    }
}
