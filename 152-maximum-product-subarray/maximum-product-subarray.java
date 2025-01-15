class Solution {
    public int maxProduct(int[] nums) {
         if (nums.length == 0) {
            return 0;
        }
        
        int maxProduct = nums[0];
        int minProduct = nums[0];
        int result = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            // To handle negative numbers, we swap maxProduct and minProduct
            if (nums[i] < 0) {
                int temp = maxProduct;
                maxProduct = minProduct;
                minProduct = temp;
            }
            
            // Calculate the maximum and minimum product ending at the current position
            maxProduct = Math.max(nums[i], maxProduct * nums[i]);
            minProduct = Math.min(nums[i], minProduct * nums[i]);
            
            // Update the result with the maximum product seen so far
            result = Math.max(result, maxProduct);
        }
        
        return result;
    }
}