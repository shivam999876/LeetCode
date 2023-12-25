class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        findCombinations(0,candidates,target,ans,new ArrayList());
        return ans;
    }
    public void findCombinations(int index,int[]candidates,int target,List<List<Integer>> ans,List<Integer> ds){
        if(index==candidates.length){
            if(target==0){
                ans.add(new ArrayList<>(ds));
            }
            return;
        }
        if(candidates[index]<=target){  //PICKED AN ELEMENT
            ds.add(candidates[index]);
            findCombinations(index,candidates,target-candidates[index],ans,ds);
            ds.remove(ds.size()-1);
        }
        findCombinations(index+1,candidates,target,ans,ds);     //NOT PICKED AN ELEMENT
    }
}