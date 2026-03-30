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
        if (root == null)
            return List.of();
        List<Integer> results = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode currentNode = queue.poll();
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                } 
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (i == 0)
                    results.add(currentNode.val);
            }
        }
        return results;
    }
}
