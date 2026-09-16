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
    int maxSum = -1000;
    public int maxPathSum(TreeNode root) {

        dfs(root);
        return maxSum;
        
    }

    public int dfs(TreeNode node){
        // base condition - 
        if(node==null) return 0;
        
        int left = Math.max(0, dfs(node.left));
        int right = Math.max(0, dfs(node.right));

        int pathSum = node.val + left + right;
        maxSum = Math.max(pathSum, maxSum);

        return node.val + Math.max(left, right);
    }
}
