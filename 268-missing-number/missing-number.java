class Solution {
    public int missingNumber(int[] nums) {
           // Total sum of first N numbers
        int n = nums.length + 1;
        int totalSum = n * (n - 1) / 2;

        // Calculate sum of all array elements
        int arraySum = 0;
        for (int num : nums) {
            arraySum += num;
        }

        // The missing number is the difference between the total sum and the array sum
        return totalSum - arraySum;
    }
}