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

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        var queue = new ArrayDeque<TreeNode>();
        queue.offer(root);
        
        var result = new ArrayList<List<Integer>>();

        while (!queue.isEmpty()) {
            var size = queue.size();
            var values = new ArrayList<Integer>();

            for (var i = 0; i < size; i++) {
                var node = queue.poll();
                values.add(node.val);

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            result.add(values);
        }

        return result;
    }
}
