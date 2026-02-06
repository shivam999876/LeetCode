class Solution {
    public int minRemoval(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);

        int i = 0;
        int maxLen = 1;

        for (int j = 0; j < n; j++) {
            long maxEl = nums[j];
            long minEl = nums[i];

            while (i < j && maxEl > (long) k * minEl) {
                i++;
                minEl = nums[i];
            }

            maxLen = Math.max(maxLen, j - i + 1);
        }

        return n - maxLen;
    }
}