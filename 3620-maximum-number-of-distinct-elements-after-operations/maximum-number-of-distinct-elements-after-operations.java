class Solution {
    public int maxDistinctElements(int[] nums, int k) {
       int n = nums.length;
       Arrays.sort(nums);
       int count = 0;
       int prev = Integer.MIN_VALUE;
       for(int i = 0; i < n; i++){
        int minVal = nums[i] - k;
        if(prev < minVal){
            prev = minVal;
            count++;
        }else if(prev < nums[i] + k){
            prev = prev + 1;
            count++;
        }
       } 
       return count;
    }
}