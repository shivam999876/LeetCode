class Solution {
    public int findKthLargest(int[] nums, int k) {
        int minValue = Arrays.stream(nums).min().getAsInt();
        int maxValue = Arrays.stream(nums).max().getAsInt();

        int[] count = new int[maxValue - minValue + 1];

        for (int num : nums) {
            count[num - minValue]++;
        }

        int remaining = k;
        for (int i = count.length - 1; i >= 0; i--) {
            remaining -= count[i];

            if (remaining <= 0) {
                return i + minValue;
            }
        }

        return -1; // This line should not be reached        
    }
}