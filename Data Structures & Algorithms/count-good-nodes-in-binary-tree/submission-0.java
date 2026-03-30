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
        
        return dfs(root, root.val); // 1, 1, 1
    }

    private int dfs(TreeNode node, int max) {
        if(node == null) return 0;

        int count = node.val >= max ? 1 : 0;  // 2 > 1
        max = Math.max(max, node.val);

        count += dfs(node.left, max); // 2, 1, 1
        count += dfs(node.right, max);
        return count;
    }
}
