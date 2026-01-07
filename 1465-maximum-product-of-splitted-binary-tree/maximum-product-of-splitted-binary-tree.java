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
    private long totalSum = 0;
    private long maxProduct = 0;
    private static final int MOD = 1_000_000_007;

    private long getTotalSum(TreeNode root){
        if(root == null) return 0;
        return root.val + getTotalSum(root.left) + getTotalSum(root.right);
    }
    private long dfs(TreeNode root){
        if(root == null) return 0;
        long leftSum = dfs(root.left);
        long rightSum = dfs(root.right);
        long subTreeSum = root.val + leftSum + rightSum;
        long product = subTreeSum * (totalSum - subTreeSum);
        maxProduct = Math.max(maxProduct, product);
        return subTreeSum; 
    }
    public int maxProduct(TreeNode root) {
        totalSum = getTotalSum(root);
        dfs(root);
        return (int)(maxProduct % MOD);
    }
}