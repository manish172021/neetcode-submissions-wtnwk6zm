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
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        Queue<LevelNode> queue = new LinkedList();
        queue.add(new LevelNode(root, 0)); // level 0
        int lastLevelInserted = -1;
        while(!queue.isEmpty()) {
            LevelNode front = queue.poll();
            if(lastLevelInserted < front.level) {
                res.add(front.node.val); 
                lastLevelInserted = front.level;
            }
            if(front.node.right != null) {
                queue.add(new LevelNode(front.node.right, front.level + 1));
            }
            if(front.node.left != null) {
                queue.add(new LevelNode(front.node.left, front.level + 1));
            }
        }
        return res;
    }

    class LevelNode {
        TreeNode node;
        int level;

        LevelNode(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }
}
