class Solution {
    private void flipWindow(int[] nums, int pos){
        nums[pos] ^= 1;
        nums[pos + 1] ^= 1;
        nums[pos + 2] ^= 1;  
    }
    public int minOperations(int[] nums) {
        int n = nums.length;
        int operations = 0;
        for(int i = 0; i < n - 2; ++i){
            if(nums[i] == 1){
                continue;
            }
            flipWindow(nums, i);
            operations++;
        }
        if(nums[n - 2] == 0 || nums[n - 1] == 0){
            return -1;
        }
        return operations;
    }
}