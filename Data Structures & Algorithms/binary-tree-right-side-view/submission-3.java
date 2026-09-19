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
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        var deque = new ArrayDeque<TreeNode>();
        deque.offer(root);

        var result = new ArrayList<Integer>();

        while (!deque.isEmpty()) {
            var size = deque.size();

            for (var i = 0; i < size; i++) {
                var node = deque.poll();

                if (i == size - 1) {
                    result.add(node.val);
                }

                if (node.left != null) {
                    deque.offer(node.left);
                }

                if (node.right != null) {
                    deque.offer(node.right);
                }
            }
        }

        return result;
    }
}
