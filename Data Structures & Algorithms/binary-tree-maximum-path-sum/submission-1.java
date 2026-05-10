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

    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);

        return max;
    }


    private int dfs(TreeNode root) {
        if(root == null) {
            return 0;
        }

        // best path coming from left subtree
        int left = dfs(root.left);

        // best path coming from right subtree
        int right = dfs(root.right);

        // negative path will only decrease answer
        // so ignore it
        left = Math.max(0, left);
        right = Math.max(0, right);




        // =========================
        // PATH USING CURRENT ROOT
        // =========================
        //
        //        root
        //       /    \
        //    left   right
        //
        // complete path:
        // left -> root -> right
        //
        // this path can become final answer
        //
        int currentPath = root.val + left + right;

        // update global maximum answer
        max = Math.max(max, currentPath);





        // =========================
        // RETURN TO PARENT
        // =========================
        //
        // parent can continue ONLY ONE side
        //
        // valid:
        // parent -> root -> left
        //
        // OR
        //
        // parent -> root -> right
        //
        // invalid:
        // parent -> left -> root -> right
        //
        // because path cannot split into 2 directions
        //
        return root.val + Math.max(left, right);
    }
}
