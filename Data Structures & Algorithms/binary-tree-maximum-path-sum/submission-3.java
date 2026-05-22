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
    private int max = Integer.MIN_VALUE;;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        var gainFromLeft = Math.max(dfs(root.left), 0);
        var gainFromRight = Math.max(dfs(root.right), 0);
        var gain = root.val + gainFromLeft + gainFromRight;
        max = Math.max(max, gain);

        return root.val + Math.max(gainFromLeft, gainFromRight);
    }
}
