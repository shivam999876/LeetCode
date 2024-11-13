class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long res = 0;
        for (int i = 0; i < nums.length; i++) {
            int low = lower - nums[i];
            int up = upper - nums[i];
            int lowIndex = findLowerBound(nums, i + 1, nums.length - 1, low);
            int upIndex = findUpperBound(nums, i + 1, nums.length - 1, up);
            if (lowIndex <= upIndex) {
                res += (upIndex - lowIndex + 1);
            }
        }
        
        return res;
    }
    private int findLowerBound(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
    private int findUpperBound(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }
}