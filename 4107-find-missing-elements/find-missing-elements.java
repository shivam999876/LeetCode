class Solution {
    public List<Integer> findMissingElements(int[] nums) {
      int mi = nums[0], ma = nums[0];
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
            if(num < mi) mi = num;
            if(num > ma) ma = num;
        }
        List<Integer> mis = new ArrayList<>();
        for(int i = mi; i <= ma; i++){
            if(!set.contains(i)) mis.add(i);
        }
        return mis;
    }
}