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
    public int maxPathSum(TreeNode root) {
        int[] ans = new int[]{Integer.MIN_VALUE};
        maxPathSum(root, ans);
        return ans[0];
    }


    private int maxPathSum(TreeNode root, int[] ans) {
        if(root == null) {
            return 0;
        }
        int left = maxPathSum(root.left, ans);
        left = Math.max(0, left); // update to remove negative
        int right = maxPathSum(root.right, ans);
        right = Math.max(0, right); // update to remove negative

        // path passing through current node
        ans[0] = Math.max(ans[0], root.val + left + right);

        // return single path to parent
        return root.val + Math.max(left, right);
    }
}
