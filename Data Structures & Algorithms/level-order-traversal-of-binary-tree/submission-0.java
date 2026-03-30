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
        if(root == null) return List.of();

        List<List<Integer>> nodes = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root); // 1

        nodes.add(List.of(root.val));

        while(!queue.isEmpty()) {
            int len = queue.size(); // 4
            List<Integer> levelNodes = new ArrayList<>(); // []

            for(int i = 0; i < len; i++) {
                TreeNode currentNode = queue.poll(); // 3

                TreeNode left = currentNode.left; // 6
                TreeNode right = currentNode.right; // 7 
                if(left != null) {
                    queue.add(left); // 4, 5, 6
                    levelNodes.add(left.val); // [4, 5, 6]
                }
                if(right != null) {
                    queue.add(right); // 4, 5, 6, 7
                    levelNodes.add(right.val); // [4, 5, 6, 7]
                }
        }
        if(!levelNodes.isEmpty()) nodes.add(levelNodes);

        }

        
            


            

        return nodes;
    }
}
