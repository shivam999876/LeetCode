class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] freq = new int[256];
        Arrays.fill(freq, 0);
        int n = s.length();
        int i = 0;
        int j = 0;
        int ans = 0;
        while (i < n) {
            if (freq[s.charAt(i)] == 1) {
                while (freq[s.charAt(i)] == 1) {
                    freq[s.charAt(j)]--;
                    j++;
                }
            }
            freq[s.charAt(i)]++;
            ans = Math.max(ans, i - j + 1);
            i++;
        }
        return ans;
    }
}