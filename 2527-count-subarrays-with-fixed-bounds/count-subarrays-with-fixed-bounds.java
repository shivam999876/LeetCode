class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long validSubarrays = 0;
        int invalidIdx = -1;
        int minKIdx = -1;
        int maxKIdx = -1;

        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] < minK || nums[i] > maxK) {
                invalidIdx = i;
            }
            
            if (nums[i] == minK) {
                minKIdx = i;
            }
            if (nums[i] == maxK) {
                maxKIdx = i;
            }

            int count = Math.max(Math.min(minKIdx, maxKIdx) - invalidIdx, 0);
            validSubarrays += count;
        }
        return validSubarrays;
    }
}