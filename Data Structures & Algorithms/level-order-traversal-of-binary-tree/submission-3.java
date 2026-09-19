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

        var deque = new ArrayDeque<TreeNode>();
        deque.offer(root);

        var result = new ArrayList<List<Integer>>();

        while (!deque.isEmpty()) {
            var size = deque.size();
            var values = new ArrayList<Integer>();

            for (var i = 0; i < size; i++) {
                var node = deque.poll();
                values.add(node.val);

                if (node.left != null) {
                    deque.offer(node.left);
                }

                if (node.right != null) {
                    deque.offer(node.right);
                }
            }

            result.add(values);
        }

        return result;
    }
}
