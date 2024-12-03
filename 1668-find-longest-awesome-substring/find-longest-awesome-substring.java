class Solution {
    public int longestAwesome(String s) {
        int[] arr = new int[1024];
        int st = 0, ans = 1;
        Arrays.fill(arr, -1);
        arr[0] = 0;
        for (int i = 1; i <= s.length(); ++i) {
            int ch = s.charAt(i - 1) - '0';
            st ^= 1 << ch;
            if (arr[st] >= 0) {
                ans = Math.max(ans, i - arr[st]);
            } else {
                arr[st] = i;
            }
            for (int j = 0; j < 10; ++j) {
                if (arr[st ^ (1 << j)] >= 0) {
                    ans = Math.max(ans, i - arr[st ^ (1 << j)]);
                }
            }
        }
        return ans;
    }
}