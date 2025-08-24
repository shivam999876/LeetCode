class Solution {
    public int longestSubarray(int[] nums) {
        int res = 0, zeroes = 0, n = nums.length;
        for(int l = 0, r = 0; r < n; r++){
            zeroes += (nums[r] ^ 1);
            while(zeroes > 1)
            zeroes -= (nums[l++] ^ 1);
            res = Math.max(res, r - l);
        }
        return res;
    }
}