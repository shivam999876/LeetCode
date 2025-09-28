class Solution {
    public int largestPerimeter(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
         for (int i = n - 3; i >= 0; i--) {
            // nums[i] < nums[i+1] < nums[i+2]
            if (nums[i] + nums[i + 1] > nums[i + 2]) { // a + b > c
                return nums[i] + nums[i + 1] + nums[i + 2];
            }
        }
        
        return 0;
    }
}