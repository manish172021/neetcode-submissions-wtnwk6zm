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
    public boolean isBalanced(TreeNode root) {
        return isBalancedHelper(root).balanced;
    }

    public Pair isBalancedHelper(TreeNode root) {
        if(root == null) {
            return new Pair(0, true);
        };
        Pair lp = isBalancedHelper(root.left);
        Pair rp = isBalancedHelper(root.right);

        int lh = lp.height;
        int rh = rp.height;

        int newHeight = 1 + Math.max(lh, rh);
        boolean newBalanced = Math.abs(lh - rh) <= 1 && lp.balanced && rp.balanced;
        Pair ans = new Pair(newHeight, newBalanced);
        return ans;
    }

    class Pair {
        int height;
        boolean balanced;
        Pair(int height, boolean balanced) {
            this.height = height;
            this.balanced = balanced;
        }
    }
}
