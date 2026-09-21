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
    private int[] preorder;
    private int preorderIndex;
    private Map<Integer, Integer> inorderPositions;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        preorderIndex = 0;
        inorderPositions = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            inorderPositions.put(inorder[i], i);
        }

        return build(0, inorder.length - 1);
    }

    private TreeNode build(int start, int end) {
        if (start > end) {
            return null;
        }

        int value = preorder[preorderIndex++];
        int rootIndex = inorderPositions.get(value);

        TreeNode root = new TreeNode(value);
        root.left = build(start, rootIndex - 1);
        root.right = build(rootIndex + 1, end);

        return root;
    }
}