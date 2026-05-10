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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        
        if (root == null) return "N";

        StringBuilder res = new StringBuilder();
        Queue<TreeNode> pendingNode = new LinkedList<>();
        pendingNode.add(root);

        while(!pendingNode.isEmpty()) {
            TreeNode front = pendingNode.poll();
            if (front == null) {
                res.append("N,");
            } 
            else {
                res.append(front.val).append(",");
                pendingNode.add(front.left);
                pendingNode.add(front.right);
            }
        }
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] vals = data.split(",");
        if (vals[0].equals("N")) return null;

        int index = 0;
        TreeNode root = new TreeNode(Integer.parseInt(vals[index++]));

        Queue<TreeNode> pendingNode = new LinkedList<>();
        pendingNode.add(root);

        
        while (!pendingNode.isEmpty()) {
            TreeNode front = pendingNode.poll();

            String leftChildData = vals[index++];
            if (!leftChildData.equals("N")) {
                TreeNode leftChild = new TreeNode(Integer.parseInt(leftChildData));
                front.left = leftChild;
                pendingNode.add(leftChild);
            }

            String rightChildData = vals[index++];
            if (!rightChildData.equals("N")) {
                TreeNode rightChild = new TreeNode(Integer.parseInt(rightChildData));
                front.right = rightChild;
                pendingNode.add(rightChild);
            }
        }
        return root;


    }
}
