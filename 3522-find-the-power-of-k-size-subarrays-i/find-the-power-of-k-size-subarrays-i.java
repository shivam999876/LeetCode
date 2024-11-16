class Solution {
    public int[] resultsArray(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        int l = 0;
        int consecCnt = 1;

        for (int r = 0; r < nums.length; r++) {
            if (r > 0 && nums[r - 1] + 1 == nums[r]) {
                consecCnt++;
            }

            if (r - l + 1 > k) {
                if (nums[l] + 1 == nums[l + 1]) {
                    consecCnt--;
                }
                l++;
            }

            if (r - l + 1 == k) {
                res.add(consecCnt == k ? nums[r] : -1);
            }
        }
        return res.stream().mapToInt(i -> i).toArray();
    }
}
