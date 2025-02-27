class Solution {
public:
    bool isPalindrome(int x) {
         if (x < 0)
        {
            return false;
        }
        long rev = 0;
        int temp = x;
        while (temp != 0)
        {
            int digit = temp % 10;
            rev = rev * 10 + digit;
            temp = temp / 10;
        }
        if (rev == x)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
};