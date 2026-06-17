class Solution {
    public String getPermutation(int n, int k) {
        StringBuilder ans = new StringBuilder();
        ArrayList<Integer> l = new ArrayList<>();
        for (int i = 1; i <= n; i++)
            l.add(i);
        int f = 1;
        for (int i = 1; i < n; i++)
            f *= i;
        k -= 1;
        while (n > 0) {
            int i = k / f;
            ans.append(l.get(i));
            l.remove(i);
            n -= 1;
            k %= f;
            if (n != 0)
                f /= n;
        }
        return ans.toString();
    }
}