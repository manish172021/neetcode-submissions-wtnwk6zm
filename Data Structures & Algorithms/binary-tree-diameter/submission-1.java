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

    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int lH = height(root.left);
        int rH = height(root.right);
        int lD = diameterOfBinaryTree(root.left);
        int rD = diameterOfBinaryTree(root.right);
        return Math.max(lH + rH, Math.max(lD, rD));
    }

    private int height(TreeNode root) {
        if(root == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }
}
