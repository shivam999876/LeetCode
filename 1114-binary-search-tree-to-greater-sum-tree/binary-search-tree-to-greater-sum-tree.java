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
    static int sum;

    public TreeNode bstToGst(TreeNode root) {
        sum = 0;
        dfs(root);
        return root; // Return the modified tree
    }

    static void dfs(TreeNode root) {
        if (root == null) return;

        dfs(root.right);   // Traverse right subtree
        sum += root.val;   // Add current node's value
        root.val = sum;    // Update node to cumulative sum
        dfs(root.left);    // Traverse left subtree
    }
}
