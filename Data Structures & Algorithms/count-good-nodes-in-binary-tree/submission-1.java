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
    private int count = 0;

    public int goodNodes(TreeNode root) {
        findGoodNodes(root, Integer.MIN_VALUE);
        return count;
    }

    private void findGoodNodes(TreeNode root, int maxSoFar) {
        if (root == null) {
            return;
        }

        if (root.val >= maxSoFar) {
            count++;
        }

        maxSoFar = Math.max(root.val, maxSoFar);
        findGoodNodes(root.left, maxSoFar);
        findGoodNodes(root.right, maxSoFar);

    }
}
