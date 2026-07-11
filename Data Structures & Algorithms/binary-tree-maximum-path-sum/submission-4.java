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
    private int result = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return result;
    }

    public int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        var leftGain = Math.max(dfs(node.left), 0);
        var rightGain = Math.max(dfs(node.right), 0);

        result = Math.max(result, node.val + leftGain + rightGain);

        return node.val + Math.max(leftGain, rightGain);
    }
}
