class Solution
{
public:
    int numSub(string s)
    {
        int mod = 1000000007;
        long count = 0;
        long ans = 0;
        for (int i = 0; i < s.size(); i++)
        {
            if (s[i] == '1')
            {
                count++;
            }
            else
            {
                long add = (count * (count + 1)) / 2;
                add = add % mod;
                ans = (ans + add) % mod;
                count = 0;
            }
        }
        long add = (count * (count + 1)) / 2;
        add = add % mod;
        ans = (ans + add) % mod;
        return (int)ans;
    }
};