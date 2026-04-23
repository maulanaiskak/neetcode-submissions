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
    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxPathSumDown(root);
        return maxSum;
    }

    private int maxPathSumDown(TreeNode node) {
        if (node == null) {
            return 0;
        }

        var left = Math.max(0, maxPathSumDown(node.left));
        var right = Math.max(0, maxPathSumDown(node.right));

        maxSum = Math.max(maxSum, left + right + node.val);

        return node.val + Math.max(left, right);
    }
}
