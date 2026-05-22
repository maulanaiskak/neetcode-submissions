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
    private boolean isBalance = false;
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        var left = checkDepth(root.left);
        var right = checkDepth(root.right);

        return Math.abs(left - right) <= 1
            && isBalanced(root.left)
            && isBalanced(root.right);
    }

    private int checkDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(checkDepth(root.left), checkDepth(root.right));
    }
}
