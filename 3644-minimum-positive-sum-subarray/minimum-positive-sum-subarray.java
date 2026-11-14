class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n = nums.size(), best = Integer.MAX_VALUE;
        for (int k = l; k <= r; k++) {
            int s = nums.subList(0, k - 1).stream().mapToInt(x -> x).sum();
            for (int i = k - 1; i < n; i++) {
                s += nums.get(i); 
                if (0 < s && s < best)
                    best = s;
                s -= nums.get(i - k + 1);
            }
        }
        return best == Integer.MAX_VALUE ? -1 : best;
    }
}