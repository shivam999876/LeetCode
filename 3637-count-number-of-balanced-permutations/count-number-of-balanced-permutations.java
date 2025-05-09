class Solution {
    private static final int MOD = 1_000_000_007;
    private long modPow(long a, int e) {
        long res = 1;
        while (e > 0) {
            if ((e & 1) == 1) res = (res * a) % MOD;
            a = (a * a) % MOD;
            e >>= 1;
        }
        return res;
    }
    public int countBalancedPermutations(String num) {
        int n = num.length();
        int[] freq = new int[10];
        int total = 0;
        for (char c : num.toCharArray()) {
            int d = c - '0';
            freq[d]++;
            total += d;
        }
        if ((total & 1) == 1) return 0;
        int half = total / 2;
        int even = (n + 1) / 2;
        int odd  = n / 2;
        long[] fact = new long[n+1], invfact = new long[n+1];
        fact[0] = 1;
        for (int i = 1; i <= n; i++) {
            fact[i] = fact[i-1] * i % MOD;
        }
        invfact[n] = modPow(fact[n], MOD-2);
        for (int i = n; i >= 1; i--) {
            invfact[i-1] = invfact[i] * i % MOD;
        }
        long[][] dp = new long[even+1][half+1];
        long[][] newdp = new long[even+1][half+1];
        dp[0][0] = 1;
        for (int d = 0; d < 10; d++) {
            int c = freq[d];
            if (c == 0) continue;
            long[] w = new long[c+1];
            for (int e = 0; e <= c; e++) {
                w[e] = invfact[e] * invfact[c-e] % MOD;
            }
            for (int i = 0; i <= even; i++) {
                Arrays.fill(newdp[i], 0, half+1, 0L);
            }
            for (int e = 0; e <= c; e++) {
                int dk = e, ds = d * e;
                if (dk > even || ds > half) break;
                long we = w[e];
                for (int i = 0; i + dk <= even; i++) {
                    long[] dpi = dp[i];
                    long[] tgt = newdp[i+dk];
                    for (int s = 0; s + ds <= half; s++) {
                        long v = dpi[s];
                        if (v != 0) {
                            tgt[s+ds] = (tgt[s+ds] + v * we) % MOD;
                        }
                    }
                }
            }
            long[][] tmp = dp;
            dp = newdp;
            newdp = tmp;
        }
        long weight = dp[even][half];
        long ans = weight * fact[even] % MOD * fact[odd] % MOD;
        return (int)ans;
    }
}