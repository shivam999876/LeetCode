class Solution {
    static private double[][] dp = new double[180][180];
    static { for (double[] r : dp) Arrays.fill(r, -1); }
    public double soupServings(int n) {
        int rem = n % 25;
        if (rem != 0) n += 25 - rem;
        int N = n / 25;
        if (N >= 180) return 1.0;
        double ans = solve(N, N);
        return ans;
    }
    private double solve(int a, int b) {
        if (a <= 0 && b <= 0) return 0.5;
        if (a <= 0) return 1.0;
        if (b <= 0) return 0.0;
        if (dp[a][b] != -1) return dp[a][b];
        double res = 0.25 * (
            solve(a-4, b) +
            solve(a-3, b-1) +
            solve(a-2, b-2) +
            solve(a-1, b-3)
        );
        return dp[a][b] = res;
    }
}