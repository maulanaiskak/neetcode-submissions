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
    private int result;

    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return result;
    }

    public int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        var leftDepth = depth(root.left);
        var rightDepth = depth(root.right);
        var diameter = leftDepth + rightDepth;
        result = Math.max(result, diameter);

        return 1 + Math.max(leftDepth, rightDepth);
    }
}
