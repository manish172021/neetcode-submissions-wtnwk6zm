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
        // List<Integer> ans = new ArrayList<>();
        // inorderMorris(root, ans);
        // return ans.get(k-1);
        return inorderMorrisStyle(root, k);
    }


       // T(n) S(1)
    private int inorderMorrisStyle(TreeNode root, int k) {
        // Inorder = Left -> Root -> Right
        while(root != null) {
            if(root.left == null) {
                // ans.add(root.val);
                k--;
                if (k == 0) return root.val;
                root = root.right;
            }
            else {
                TreeNode curr = root.left;
                while(curr.right != null && curr.right != root) {
                    curr = curr.right;
                }
                if(curr.right == null) {
                    curr.right = root;
                    root = root.left;
                }
                else {
                    curr.right = null;
                    // ans.add(root.val);
                    k--;
                    if (k == 0) return root.val;
                    root = root.right;
                }
            }
        }
        return -1;
    }

    private void inorder(TreeNode root, List<Integer> ans) {
        if(root == null) return;
        inorder(root.left, ans);
        ans.add(root.val);
        inorder(root.right, ans);
    }

    // T(n) S(1)
    private void inorderMorris(TreeNode root, List<Integer> ans) {
        // Inorder = Left -> Root -> Right
        while(root != null) {
            // Case 1:
            // No left subtree
            // directly process root and move right
            if(root.left == null) {
                ans.add(root.val);
                root = root.right;
            }
            // Case 2:
            // Left subtree exists
            else {
                // Find inorder predecessor = rightmost node in left subtree
                TreeNode curr = root.left;
                while(curr.right != null && curr.right != root) {
                    curr = curr.right;
                }
                // First time visiting root
                // create thread/link back to root
                // then move left
                if(curr.right == null) { // left tree not traversed 
                    curr.right = root;
                    root = root.left;
                }
                // Second time visiting root
                // left subtree already traversed
                // remove thread, process root, move right
                else {
                    curr.right = null;
                    ans.add(root.val);
                    root = root.right;
                }
            }
        }
    }


}
