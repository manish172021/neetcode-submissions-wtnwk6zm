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
    public int goodNodes(TreeNode root) {
        if(root == null) return 0;
        return goodNodes(root, root.val);
    }

    public int goodNodes(TreeNode root, int currMax) {
        if(root == null) return 0;

        int ans = 0;
        if(root.val >= currMax) {
            ans = 1;
            currMax = root.val;
        }

        int leftAns = goodNodes(root.left, currMax);
        int rightAns = goodNodes(root.right, currMax);
        
        return ans + leftAns + rightAns;
    }
}
