class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0]; // Initialize maxSum to the first element of the array
        int currentSum = nums[0]; // Initialize currentSum to the first element of the array
        
        // Iterate through the array starting from the second element
        for (int i = 1; i < nums.length; i++) {
            // Calculate the maximum between the current element and the currentSum + current element
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            
            // Update maxSum if the currentSum is greater than the current maxSum
            maxSum = Math.max(maxSum, currentSum);
        }
        
        return maxSum;
    }
}