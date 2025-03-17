class Solution {
    public boolean divideArray(int[] nums) {
        Set<Integer> remaining = new HashSet<>();
        for(int ele : nums){
            if(remaining.contains(ele)){
                remaining.remove(ele);
            }else{
                remaining.add(ele);
            }
        }
        return remaining.size() == 0;
    }
}