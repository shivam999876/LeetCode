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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> ans=new ArrayList<>();    
    if(root==null) return ans;
    Queue<TreeNode> q=new LinkedList<>();
    q.add(root);
    boolean check=true;
    while(!q.isEmpty()){
        int size=q.size();
        List<Integer> current=new ArrayList<>(Collections.nCopies(size,0));
        for(int i=0;i<size;i++){
            TreeNode node=q.poll();
            int idx=check?i:(size-1-i);
            current.set(idx,node.val);
            if(node.left!=null) q.add(node.left);
            if(node.right!=null) q.add(node.right);
        }
        check=!check;
        ans.add(current);
    }
    return ans;
    }
}