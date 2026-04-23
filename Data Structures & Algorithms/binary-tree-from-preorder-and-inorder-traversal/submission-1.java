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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        var inorderMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        
        return build(preorder, 0, preorder.length - 1,
                     inorder, 0, inorder.length - 1,
                     inorderMap);
    }
    
    private TreeNode build(int[] preorder, int preStart, int preEnd,
                          int[] inorder, int inStart, int inEnd,
                          Map<Integer, Integer> inorderMap) {
        // Base case
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        
        // Step 1: ROOT = first element di preorder
        var rootVal = preorder[preStart];
        var root = new TreeNode(rootVal);
        
        // Step 2: Find ROOT position di inorder
        var rootIdx = inorderMap.get(rootVal);
        
        // Step 3: Calculate left subtree size
        var leftSize = rootIdx - inStart;
        
        // Step 4: Recurse left subtree
        root.left = build(preorder, preStart + 1, preStart + leftSize,
                         inorder, inStart, rootIdx - 1,
                         inorderMap);
        
        // Step 5: Recurse right subtree
        root.right = build(preorder, preStart + leftSize + 1, preEnd,
                          inorder, rootIdx + 1, inEnd,
                          inorderMap);
        
        return root;
    }
}