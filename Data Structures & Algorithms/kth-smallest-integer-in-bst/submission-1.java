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

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> ans = new ArrayList<>();
        inorderMorris(root, ans);
        return ans.get(k-1);
    }

    private void inorder(TreeNode root, List<Integer> ans) {
        if(root == null) return;
        inorder(root.left, ans);
        ans.add(root.val);
        inorder(root.right, ans);
    }

    private void inorderMorris(TreeNode root, List<Integer> ans) {
        // Left Node Right
        while(root != null) {
            // 1. left don't exist
            if(root.left == null) {
                ans.add(root.val);
                root = root.right;
            }
            else { // 2. if left exist
                // 2.1 traverse root -> left the its right ... right ..
                TreeNode curr = root.left;
                while(curr.right != null && curr.right != root) {
                    curr = curr.right;
                }
                // 2.2 If we dont have created link of left->right...right with root
                // create link and move to left
                if(curr.right == null) { // left tree not traversed 
                    curr.right = root;
                    root = root.left;
                }
                else { // 2.3 if link is there i.e, curr.right == root then remove link and add root
                    curr.right = null;
                    ans.add(root.val);
                    root = root.right;
                }
            }
        }
    }

}
