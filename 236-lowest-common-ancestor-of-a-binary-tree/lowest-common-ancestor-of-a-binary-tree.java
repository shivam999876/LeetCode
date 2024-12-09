/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    TreeNode node;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return root;
        traverse(root, p, q);
        return node;

    }

    boolean traverse(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }

        boolean left = traverse(root.left, p, q);
        boolean right = traverse(root.right, p, q);
        if (left && right || ((left || right) && root == p) || ((left || right) && root == q)) {
            node = root;
        }
        if (root == p || root == q) {
            return true;
        }
        
        return left || right;

    }

}