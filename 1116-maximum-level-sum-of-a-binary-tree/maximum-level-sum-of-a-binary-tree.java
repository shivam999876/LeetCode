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
    private Map<Integer, Integer> mp = new HashMap<>();

    private void DFS(TreeNode root, int currLevel) {
        if (root == null) {
            return;
        }

        mp.put(currLevel, mp.getOrDefault(currLevel, 0) + root.val);

        DFS(root.left, currLevel + 1);
        DFS(root.right, currLevel + 1);
    }

    public int maxLevelSum(TreeNode root) {
        mp.clear();
        DFS(root, 1);

        int maxSum = Integer.MIN_VALUE;
        int result = 0;

        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            int level = entry.getKey();
            int sum = entry.getValue();

            if (sum > maxSum) {
                maxSum = sum;
                result = level;
            }
        }

        return result;
    }
}