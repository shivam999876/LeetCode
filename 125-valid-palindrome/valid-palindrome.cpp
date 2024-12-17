class Solution {
public:
    bool isPalindrome(string s) {
        int start = 0;
        int last = s.size() - 1;
        while (start <= last)
        {
            if (!isalnum(s[start]))
            {
                start++;
            }
            else if (!isalnum(s[last]))
            {
                last--;
            }
            else if (tolower(s[start]) != tolower(s[last]))
            {
                return false;
            }
            else
            {
                start++;
                last--;
            }
        }
        return true;
    }
};