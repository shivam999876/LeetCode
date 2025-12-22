class Solution {
    public int minDeletionSize(String[] strs) {
        int rows = strs.length;
        int cols = strs[0].length();
        int[] dp = new int[cols];
        int LIS = 1;
        for(int i = 0; i < cols; i++){
            dp[i] = 1;
            for(int j = 0; j < i; j++){
                boolean valid = true;
                for(int k = 0; k < rows; k++){
                    if(strs[k].charAt(j) > strs[k].charAt(i)){
                        valid = false;
                        break;
                    }
                }
                if(valid){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            LIS = Math.max(LIS, dp[i]);
        }
        return cols - LIS;
    }
}