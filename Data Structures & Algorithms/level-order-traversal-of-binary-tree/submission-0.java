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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();
         
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> pendingNode = new LinkedList();
        pendingNode.add(root);

        while(!pendingNode.isEmpty()) {

            int size = pendingNode.size();
            List<Integer> level = new ArrayList<>();
            
            for(int i = 0; i < size; i++) {
                TreeNode front = pendingNode.poll();
                level.add(front.val);

                if(front.left != null) {
                    pendingNode.offer(front.left);
                }

                if(front.right != null) {
                    pendingNode.offer(front.right);
                }
            }
            ans.add(level);
        }
        return ans;
    }
}
