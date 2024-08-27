import java.util.ArrayList;

class Solution {
    public int fibon(int n, ArrayList<Integer> dp) {
        // Base Case
        if (n <= 1)
            return n;

        // Already calculated result (Fibonacci number)
        if (dp.get(n) != -1)
            return dp.get(n);

        // Store and return the result
        dp.set(n, fibon(n - 1, dp) + fibon(n - 2, dp));
        return dp.get(n);
    }

    public int fib(int n) {
        if (n <= 1)
            return n;

        // Initialize dp array with size 'n+1'
        ArrayList<Integer> dp = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            dp.add(-1);
        }

        // Fill base cases
        dp.set(0, 0);
        dp.set(1, 1);

        // Iterative calculation of Fibonacci numbers
        for (int i = 2; i <= n; i++) {
            dp.set(i, dp.get(i - 1) + dp.get(i - 2));
        }

        // Return the nth Fibonacci number
        return dp.get(n);
    }
}