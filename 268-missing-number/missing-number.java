class Solution {
    public int missingNumber(int[] nums) {
        int n_xor = nums.length;
        for(int i = 0; i < nums.length; i++){
            n_xor = n_xor ^ i;
            n_xor = n_xor ^ nums[i];
        }
        return n_xor;
        
    }
}