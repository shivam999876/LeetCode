class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int freq[256] = {};
        int n = s.size();
        int i = 0;
        int j = 0;
        int ans = 0;
        while (i < n) {
            if (freq[s[i]] == 1) {
                while (freq[s[i]] == 1) {
                    freq[s[j]]--;
                    j++;
                }
            }
            freq[s[i]]++;
            ans = max(ans, i - j + 1);
            i++;
        }
        return ans;
    }
};