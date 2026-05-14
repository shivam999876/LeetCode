class Solution {
    private static final int[] S = new int[201];
    private static int vers = 0;

    public boolean isGood(int[] nums) {
        vers++;
        int n = nums.length - 1;

        for (int num : nums) {
            if (num > n || S[num] == -vers) return false;

            if (S[num] == vers) {
                if (num < n) return false;
                S[num] = -vers;
                continue;
            }

            S[num] = vers;
        }

        return true;
    }
}