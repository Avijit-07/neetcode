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
        if(root == null) return 0;

        List<Integer> treeList = new ArrayList<>();
        dfs(root, treeList, k);

        return treeList.get(k-1);

    }

    private void dfs(TreeNode node, List<Integer> treeList, int k) {
        if(node == null || treeList.size() == k) return;
        if(node.left != null) dfs(node.left, treeList, k); // 

        treeList.add(node.val); // 1

        if(node.right != null) dfs(node.right, treeList, k);
    }
 
}
