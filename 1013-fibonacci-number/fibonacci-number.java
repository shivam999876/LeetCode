class Solution {
    public int fibon(int n, ArrayList<Integer> dp) {
        // Base Case
        if (n <= 1)
            return n;
        
        // Check if value is already calculated
        if (dp.get(n) != -1)
            return dp.get(n);
        
        // Memoization
        dp.set(n, fibon(n - 1, dp) + fibon(n - 2, dp));
        return dp.get(n);
    }

    public int fib(int n) {
        ArrayList<Integer> dp = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            dp.add(-1);
        }
        return fibon(n, dp);
    }
}