class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for(String str : strs){
            int zeroes = 0, ones = 0;
            for(char ch : str.toCharArray()){
                if(ch == '0')
                zeroes++;
                else
                ones++;
            }
            for(int zero = m; zero >= zeroes; zero--){
                for(int one = n; one >= ones; one--){
                    dp[zero][one] = Math.max(dp[zero][one], dp[zero - zeroes][one - ones] + 1);
                }
            }
        }
        return dp[m][n];
    }
}