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
    TreeNode n;
    int k;
    
    
    public void getKthSmallestUsingInorder(TreeNode node) {
        if (node == null)
            return;
        
        
        getKthSmallestUsingInorder(node.left);
        
        
        this.k--;
        
        if (this.k == 0)
            this.n = node;
        
        
        if (this.k > 0)
            getKthSmallestUsingInorder(node.right);
    }
    
    
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        getKthSmallestUsingInorder(root);
        return this.n.val;
    }
}