class Solution {
    public int numberOfWays(String corridor) {
        int mod = 1_000_000_007;
        long s0 = 0, s1 = 0, s2 = 1;

        for (char c : corridor.toCharArray()) {
            if (c == 'S') {
                long t = s1;
                s1 = s2;
                s2 = t;
                s0 = t;
            } else {
                s2 = (s2 + s0) % mod;
            }
        }
        return (int) s0;
    }
}