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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        
        var levelNodes = new ArrayDeque<TreeNode>();
        levelNodes.add(root);

        var result = new ArrayList<List<Integer>>();

        while (!levelNodes.isEmpty()) {
            var levelSize = levelNodes.size();
            var levelResult = new ArrayList<Integer>();

            for (var i = 0; i < levelSize; i++) {
                var node = levelNodes.poll();

                if (node != null) {
                    levelResult.add(node.val);
                }

                if (node.left != null) {
                    levelNodes.add(node.left);
                }

                if (node.right != null) {
                    levelNodes.add(node.right);
                }
            }

            if (!levelResult.isEmpty()) {
                result.add(levelResult);
            }
        }

        return result;
    }
}
