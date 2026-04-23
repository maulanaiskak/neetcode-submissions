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
    private int count;

    public int goodNodes(TreeNode root) {
        countValidNodes(root, Integer.MIN_VALUE);
        return count;
    }

    private void countValidNodes(TreeNode node, int maxSoFar) {
        if (node == null) {
            return;
        }

        if (node.val >= maxSoFar) {
            count++;
        }

        maxSoFar = Math.max(maxSoFar, node.val);

        countValidNodes(node.left, maxSoFar);
        countValidNodes(node.right, maxSoFar);
    }
}
