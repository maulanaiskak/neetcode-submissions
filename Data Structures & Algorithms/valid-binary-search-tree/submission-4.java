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
    private boolean isValid = true;
    
    public boolean isValidBST(TreeNode root) {
        dfs(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return isValid;
    }

    private void dfs(TreeNode node, int low, int high) {
        if (node == null) {
            return;
        }

        if (node.val <= low || node.val >= high) {
            isValid = false;
            return;
        }

        dfs(node.left, low, node.val);
        dfs(node.right, node.val, high);
    }
}
