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
    TreeMap<Integer,TreeMap<Integer,ArrayList<Integer>>> ans=new TreeMap();
    List<List<Integer>> res=new ArrayList();
    private void compute(TreeNode root,int hd,int lvl){
        if(root==null) return;
        ans.putIfAbsent(hd,new TreeMap<>());  
        ans.get(hd).putIfAbsent(lvl, new ArrayList<>());
        ans.get(hd).get(lvl).add(root.val);
        compute(root.left,hd-1,lvl+1);
        compute(root.right,hd+1,lvl+1);   
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        compute(root,0,0);
        System.out.println(ans);
        for (Map.Entry<Integer, TreeMap<Integer, ArrayList<Integer>>> outer : ans.entrySet()) {
            for (Map.Entry<Integer, ArrayList<Integer>> inner : outer.getValue().entrySet()) {
                Collections.sort(inner.getValue());
            }
        }
        for(Map.Entry<Integer,TreeMap<Integer,ArrayList<Integer>>> outer:ans.entrySet()){
            List<Integer> temp=new ArrayList();
            for(Map.Entry<Integer,ArrayList<Integer>> inner:outer.getValue().entrySet()){
                temp.addAll(inner.getValue());
            }
            res.add(temp);
        }
        return res;
    }
}