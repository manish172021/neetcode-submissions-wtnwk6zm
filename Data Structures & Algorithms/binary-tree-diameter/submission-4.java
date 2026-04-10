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
        // if(root == null) {
        //     return 0;
        // }
        // int lH = height(root.left);
        // int rH = height(root.right);
        // int lD = diameterOfBinaryTree(root.left);
        // int rD = diameterOfBinaryTree(root.right);
        // return Math.max(lH + rH, Math.max(lD, rD));
        return diameterOfBinaryTree1(root).diameter;
    }
    // T(n)
    private Pair diameterOfBinaryTree1(TreeNode root) {
        if(root == null) {
            Pair ans = new Pair();
            ans.height = 0;
            ans.diameter = 0;
            return ans;
        }
        Pair left = diameterOfBinaryTree1(root.left);
        Pair right = diameterOfBinaryTree1(root.right);
        int lH = left.height;
        int rH = right.height;
        int lD = left.diameter;
        int rD = right.diameter;
        Pair ans = new Pair();
        ans.height = 1 + Math.max(lH, rH);
        ans.diameter = Math.max(lH + rH, Math.max(lD, rD));;
        return ans;
    }


    private int height(TreeNode root) {
        if(root == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    class Pair {
        int height;
        int diameter;
    }


}
