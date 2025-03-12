class Solution {
    public int maximumCount(int[] nums) {
        int n = nums.length;
        int lb = lowerBound(nums, 0);
        int ub = upperBound(nums, 0);
        return Math.max(lb, n - ub);
    }
    private int lowerBound(int[] nums, int target){
        int left = 0, right = nums.length;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] < target){
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
    private int upperBound(int[] nums, int target){
        int left = 0, right = nums.length;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] <= target){
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}