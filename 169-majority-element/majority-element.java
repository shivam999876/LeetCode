class Solution {
    public int majorityElement(int[] nums) {
         int majority = 0;  // Initialize the potential majority element
        int count = 0;     // Initialize the count

        for (int num : nums) {
            if (count == 0) {
                majority = num;
            }

            if (num == majority) {
                count++;
            } else {
                count--;
            }
        }

        return majority;
    }
}