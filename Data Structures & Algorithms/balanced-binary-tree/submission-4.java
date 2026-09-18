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
    private boolean balanced = true;
    
    public boolean isBalanced(TreeNode root) {
        depth(root);
        return balanced;
    }

    public int depth(TreeNode root) {
        if (root == null || !balanced) {
            return 0;
        }

        var leftDepth = depth(root.left);
        var rightDepth = depth(root.right);

        if (Math.abs(leftDepth - rightDepth) > 1) {
            balanced = false;
        } 

        return 1 + Math.max(leftDepth, rightDepth);
    }
}
