class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long res = 0;
        long curSum = 0;
        int[] freq = new int[100001];
        int l = 0;
        
        for (int r = 0; r < nums.length; r++) {
            curSum += nums[r];
            freq[nums[r]]++;

            while (freq[nums[r]] > 1 || (r - l + 1) > k) {
                curSum -= nums[l];
                freq[nums[l]]--;
                l++;
            }
            
            if (r - l + 1 == k) {
                res = Math.max(res, curSum);
            }
        }
        
        return res;
    }
}
