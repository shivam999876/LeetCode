class Solution {
    private static final long MOD = 1_000_000_007L;
    public int numOfWays(int[] nums) {
        int n = nums.length;
        int[] born = new int[n + 2]; 
        Arrays.fill(born, -1);
        for (int i = 0; i < n; i++) born[nums[i]] = i;

        long fact = 1, sizes = 1;
        for (int k = 2; k <= n; k++) fact = fact * k % MOD;
        int[] stack = new int[n + 2];  
        int top = 0;
        for (int v = 1; v <= n + 1; v++) {
            while (born[stack[top]] > born[v]) {  
                top--;
                sizes = sizes * (v - stack[top] - 1) % MOD;  
            }
            stack[++top] = v;
        }
        return (int) ((fact * power(sizes, MOD - 2) - 1 + MOD) % MOD);  
    }
    private long power(long b, long e) {
        long r = 1;
        for (b %= MOD; e > 0; e >>= 1, b = b * b % MOD)
            if ((e & 1) == 1) r = r * b % MOD;
        return r;
    }
}