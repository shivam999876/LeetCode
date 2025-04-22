class Solution {
    private static final int MOD = 1_000_000_007;

    public int Comb(int n, int k, int[][] memo) {
        if (k == 0) return 1;
        if (n == 0) return 0;

        if (memo[n][k] != 0) return memo[n][k];

        memo[n][k] = (Comb(n - 1, k, memo) + Comb(n - 1, k - 1, memo)) % MOD;
        return memo[n][k];
    }

    public int count(int val, int ind, int n, int maxV, int[][] dp, int[][] memo) {
        if (ind == n) {
            return 1;
        }

        if (dp[ind][val] != -1) {
            return dp[ind][val];
        }

        long ans = 0;
        boolean flag = false;

        for (int j = 2; val * j <= maxV; j++) {
            ans = (ans + count(val * j, ind + 1, n, maxV, dp, memo)) % MOD;
            flag = true;

            if (val * (j + 1) > maxV) {
                ans = (ans + Comb(n - 1, ind - 1, memo)) % MOD;
            }
        }

        if (!flag) {
            ans = (ans + Comb(n - 1, ind - 1, memo)) % MOD;
        }

        dp[ind][val] = (int) ans;
        return dp[ind][val];
    }

    public int idealArrays(int n, int maxV) {
        int[][] dp = new int[15][maxV + 1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        int[][] memo = new int[n + 1][15];

        long ans = 0;

        for (int i = 1; i <= maxV; i++) {
            ans = (ans + count(i, 1, n, maxV, dp, memo)) % MOD;
        }

        return (int) ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.idealArrays(2, 5));  // Output: 10
        System.out.println(solution.idealArrays(3, 4));  // Test with other cases
    }
}